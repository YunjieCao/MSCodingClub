public class week29_1021 {
    class Solution {
        public String removeOuterParentheses(String S) {
            StringBuilder ret = new StringBuilder();
            char[] s = S.toCharArray();
            int start = 0;
            int i = 0;
            int n = s.length;
            int left = 0;
            while (i < n) {
                if (s[i] == '(') {
                    left ++;
                    i ++;
                } else {
                    left --;
                    if (left == 0) {
                        ret.append(S.substring(start+1, i));
                        i ++;
                        start = i;
                    } else {
                        i ++;
                    }
                }
            }
            return ret.toString();
        }
    }
}