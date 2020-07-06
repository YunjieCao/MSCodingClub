import java.util.*;
public class week29_456 {
    class Solution {
        public boolean find132pattern(int[] nums) {
            int n = nums.length;
            if (n < 3) return false;
            int[] mins = new int[n];
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                min = Math.min(min, nums[i]);
                mins[i] = min;
            }
            Stack<Integer> st = new Stack<>();
            for (int i = n-1; i > 0; i--) {
                while (!st.isEmpty() && nums[i] > st.peek()) {
                    // store 2s in stack(descending order) 
                    if (mins[i-1] < st.peek()) return true;
                    st.pop();
                }
                st.push(nums[i]);
            }
            return false;
        }
    }
}