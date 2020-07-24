public class week31_169 {
    class Solution {
        public int majorityElement(int[] nums) {
            int num = nums[0];
            int cnt = 1;
            int n = nums.length;
            for (int i = 1; i < n; i++) {
                if (nums[i] == num) {
                    cnt ++;
                } else {
                    if (cnt == 0) {
                        num = nums[i];
                        cnt = 1;
                    } else {
                        cnt --;
                    }
                }
                
            }
            return num;
        }
    }
}