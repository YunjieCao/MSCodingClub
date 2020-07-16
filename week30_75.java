public class week30_75 {
    class Solution {
        public void sortColors(int[] nums) {
            int n = nums.length;
            int ptr1 = 0, ptr2 = n - 1;
            int ptr = 0;
            while (ptr <= ptr2) {
                if (nums[ptr] == 0) {
                    swap(nums, ptr, ptr1);
                    ptr ++;
                    ptr1 ++;
                } else if (nums[ptr] == 2) {
                    swap(nums, ptr, ptr2);
                    ptr2 --;
                } else {
                    ptr ++;
                }
            }
        }
        
        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}