import java.util.*;
public class week30_324 {
    class Solution {
        public void wiggleSort(int[] nums) {
            Arrays.sort(nums);
            int[] temp = nums.clone();
            int ptr = temp.length - 1;
            for (int i = 1; i < nums.length; i+=2) {
                nums[i] = temp[ptr--];
            }
            for (int i = 0; i < nums.length; i+=2) {
                nums[i] = temp[ptr--];
            }
            
        }
    }
}