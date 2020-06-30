public class week28_392 {
    class Solution {
        public boolean isSubsequence(String s, String t) {
            char[] strs = s.toCharArray();
            char[] strt = t.toCharArray();
            int ptrs = 0, ptrt = 0;
            int lens = strs.length, lent = strt.length;
            while (ptrs < lens && ptrt < lent) {
                if (strs[ptrs] == strt[ptrt]) {
                    ptrs ++;
                    ptrt ++;
                } else {
                    ptrt ++;
                }
            }
            return ptrs == lens;
        }
    }
}