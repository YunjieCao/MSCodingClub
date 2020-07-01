import java.util.*;
public class week28_523 {
    class Solution {
        public boolean checkSubarraySum(int[] nums, int k) {
            HashMap<Integer, Integer> map = new HashMap<>();
            int sum = 0;
            int n = nums.length;
            if (n < 2) return false;
            long K = (Math.abs((long)k));
            if (K == 0) {
                for (int i = 0; i < n-1; i++) {
                    if (nums[i] == 0 && nums[i+1] == 0) {
                        return true;
                    }
                }
                return false;
            }
            map.put(0, -1);
            for (int i = 0; i < n; i++) {
                sum += nums[i];
                int pos = (int)((long)sum % K);
                if (map.containsKey(pos)) {
                    if (i-map.get(pos) > 1) return true;
                } else {
                    map.put(pos, i);
                }
            }
            return false;
        }
    }
}