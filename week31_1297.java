import java.util.*;
public class week31_1297 {
    class Solution {
        public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
            return getSub(s, minSize, maxLetters);
        }
        
        private int getSub(String s, int len, int maxLetters) {
            if (len > s.length()) return 0;
            int ret = 0;
            HashMap<String, Integer> count = new HashMap();
            HashMap<Character, Integer> letters = new HashMap();
            for (int i = 0; i < len; i++) {
                letters.put(s.charAt(i), letters.getOrDefault(s.charAt(i), 0) + 1);
            }
            if (letters.size() <= maxLetters) {
                count.put(s.substring(0, len), 1);
                ret = 1;
            }
            for (int i = len; i < s.length(); i++) {
                letters.put(s.charAt(i), letters.getOrDefault(s.charAt(i), 0) + 1);
                letters.put(s.charAt(i-len), letters.getOrDefault(s.charAt(i-len), 0) - 1);
                if (letters.get(s.charAt(i-len)) == 0) letters.remove(s.charAt(i-len));
                if (letters.size() <= maxLetters) {
                    String cur = s.substring(i-len+1, i+1);
                    count.put(cur, count.getOrDefault(cur, 0)+1);
                    ret = Math.max(ret, count.get(cur));
                }
            }
            return ret;
        }
    }
}