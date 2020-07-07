import java.util.*;
public class week29_880 {
    class Solution {
        public String decodeAtIndex(String S, int K) {
            long len = 0;
            Stack<Character> st = new Stack<>();
            char[] str = S.toCharArray();
            for (char c: str) {
                if (c >= '0' && c <= '9') {
                    len = len * (long)(c-'0');
                } else {
                    st.push(c);
                    len ++;
                }
            }
            //System.out.println(len);
            char ret = '0';
            long k = (long)(K);
            for (int i = str.length-1; i >= 0; i--) {
                if (len == k || k == 0) {
                    ret = st.peek();
                    break;
                }
                if (str[i] >= '0' && str[i] <= '9') {
                    int times = (int)(str[i]-'0');
                    len /= times;
                    k %= len;
                } else {
                    len --;
                    st.pop();
                }
            }
            return String.valueOf(ret);
        }
    }
}