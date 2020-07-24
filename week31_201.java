public class week31_201 {
    class Solution {
        public int rangeBitwiseAnd(int m, int n) {
            if (m > n) return 0;
            
            while (n > m) {
                n = n & (n - 1);
            }
            
            return n;
        }
    }
}