public class week31_461 {
    class Solution {
        public int hammingDistance(int x, int y) {
            int cur = x ^ y;
            int ret = 0;
            while (cur > 0) {
                if ((cur&1) != 0) ret++;
                cur >>= 1;
            }
            return ret;
        } 
    }
}