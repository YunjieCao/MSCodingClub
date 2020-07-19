import java.util.*;
public class week30_524 {
    class Solution {
        public String findLongestWord(String s, List<String> d) {
            String ret = "";
            char[] S = s.toCharArray();
            for (String word: d) {
                if (contain(S, word.toCharArray())) {
                    if (word.length() > ret.length()) {
                        ret = word;
                    } else if (word.length() == ret.length()) {
                        if (word.compareTo(ret) < 0) {
                            ret = word;
                        }
                    }
                }
            }
            return ret;
        }
        
        private boolean contain(char[] s, char[] d) {
            int ptr1 = 0, ptr2 = 0;
            while (ptr1 < s.length && ptr2 < d.length) {
                if (s[ptr1] == d[ptr2]) {
                    ptr1++;
                    ptr2++;
                } else {
                    ptr1++;
                }
            }
            if (ptr2 == d.length) return true;
            else return false;
        }
    }
}