import java.util.*;
public class week31_1178 {
    class Solution {
        public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
            List<Integer> ret = new ArrayList<>();
            int n = words.length;
            long[] words_ = new long[n];
            for (int i = 0; i < n; i++) {
                words_[i] = getNum(words[i]);
            }
            for (String puzzle: puzzles) {
                long cur = getNum(puzzle);
                long first = getNum(puzzle.substring(0,1));
                int temp = 0;
                
                for (long w: words_) {
                    if ((w&first) == 0) continue;
                    long target = (w & cur);
                    if ((target^w) == 0) {
                        temp ++;
                    }
                }
                ret.add(temp);
            }
            return ret;
        }
        
        
        private long getNum(String word) {
            long ret = 0;
            for (char c: word.toCharArray()) {
                long cur = 1 << (int)(c-'a');
                ret |= cur;
            }
            return ret;
        }
    }
}