public class week28_740 {
    class Solution {
        public int deleteAndEarn(int[] nums) {
            int[] freq = new int[10005];
            int[][] dp = new int[10005][2];
            // dp[i][0] delete i, dp[i][1] do not delete i
            int ret = 0;
            
            for (int num: nums) {
                freq[num] ++;
            }
            
            for (int i = 1; i <= 10000; i++) {
                if (freq[i] > 0) {
                    dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1]);
                    dp[i][0] = (freq[i-1] > 0? dp[i-1][1]: Math.max(dp[i-1][0], dp[i-1][1])) + freq[i] * i;
                } else {
                    dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
                    dp[i][1] = dp[i][0];
                }
                ret = Math.max(ret, Math.max(dp[i][0], dp[i][1]));    
            }
            return ret;
        }
    }
}