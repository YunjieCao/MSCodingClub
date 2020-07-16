import java.util.*;
public class week30_1403 {
    class Solution {
        public List<Integer> minSubsequence(int[] nums) {
            int n = nums.length;
            int sum = 0, temp = 0;
            List<Integer> ret = new ArrayList<>();
            if (n == 0) return ret;
            Arrays.sort(nums);
            for (int i = 0; i < n; i++) {
                sum += nums[i];
            }
            for (int i = n-1; i >= 0; i--) {
                temp += nums[i];
                ret.add(nums[i]);
                if (temp > sum - temp) {
                    break;
                }
            }
            return ret;
        }
    }
}