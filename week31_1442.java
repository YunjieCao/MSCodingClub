import java.util.*;
public class week31_1442 {
    class Solution {
        public int countTriplets(int[] arr) {
            int ret = 0;
            int n = arr.length;
            int[][] dp = new int[n][n];
            for (int i = 0; i < n; i++) {
                dp[i][i] = arr[i];
            }
            for (int l = 2; l <= n; l++) {
                for (int i = 0; i <= n-l; i++) {
                    dp[i][i+l-1] = dp[i][i+l-2] ^ arr[i+l-1];
                }
            }
            for (int j = 0; j < n; j++) {
                HashMap<Integer, Integer> map = new HashMap<>();
                for (int i = 0; i < j; i++) {
                    map.put(dp[i][j-1], map.getOrDefault(dp[i][j-1], 0) + 1);
                }
                for (int k = j; k < n; k++) {
                    ret += map.getOrDefault(dp[j][k], 0);
                }
            }
            return ret;
        }
    }
}