import java.util.*;
public class week31_187 {
    class Solution {
        public List<String> findRepeatedDnaSequences(String s) {
            List<String> ret = new ArrayList();
            if (s.length() <= 10) return ret;
            HashMap<Long, Integer> map = new HashMap();
            long cur = 0;
            char[] chr = s.toCharArray();
            for (int i = 0; i < 10; i++) {
                if (chr[i] == 'A') {
                    cur = cur * 10 + 1;
                } else if (chr[i] == 'C') {
                    cur = cur * 10 + 2;
                } else if (chr[i] == 'T') {
                    cur = cur * 10 + 3;
                } else {
                    cur = cur * 10 + 4;
                }
            }
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            long modulo = 1000000000;
            for (int i = 10; i < s.length(); i++) {
                cur = cur % modulo;
                if (chr[i] == 'A') {
                    cur = cur * 10 + 1;
                } else if (chr[i] == 'C') {
                    cur = cur * 10 + 2;
                } else if (chr[i] == 'T') {
                    cur = cur * 10 + 3;
                } else {
                    cur = cur * 10 + 4;
                }
                map.put(cur, map.getOrDefault(cur, 0) + 1);
            }
            for (Long n: map.keySet()) {
                if (map.get(n) > 1) {
                    ret.add(getString(n));
                }
            }
            return ret;
        }
        
        private String getString(long n) {
            StringBuilder s = new StringBuilder();
            while (n > 0) {
                long left = n % 10;
                n /= 10;
                if (left == 1) {
                    s.append('A');
                } else if (left == 2) {
                    s.append('C');
                } else if (left == 3) {
                    s.append('T');
                } else {
                    s.append('G');
                }
            }
            return s.reverse().toString();
        }
        
    }

}