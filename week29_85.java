import java.util.*;
public class week29_85 {
    class Solution {
        public int maximalRectangle(char[][] matrix) {
            int n = matrix.length;
            if (n == 0) return 0;
            int m = matrix[0].length;
            if (m == 0) return 0;
            int[] height = new int[m];
            int ret = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (matrix[i][j] == '0') {
                        height[j] = 0;
                    } else {
                        height[j] ++;
                    }
                }
                ret = Math.max(ret, getMaxRec(height));
            }
            return ret;
        }
        
        private int getMaxRec(int[] height) {
            Stack<Integer> st = new Stack<>();
            int ret = 0;
            for (int i = 0; i <= height.length; i++) {
                int h = (i == height.length) ? 0: height[i];
                while (!st.isEmpty() && h <= height[st.peek()]) {
                    int leftInd = st.pop();
                    if (st.isEmpty()) {
                        ret = Math.max(ret, height[leftInd] * i);
                    } else {
                        ret = Math.max(ret, height[leftInd] * (i-st.peek()-1));
                    }
                }
                st.push(i);
            }
            return ret;
        }
    }
}