import java.util.*;
public class week31_1255 {
    class Solution {
        int ans = 0;
        public int maxScoreWords(String[] words, char[] letters, int[] score) {
            HashMap<Character, Integer> scores = new HashMap();
            for (int i = 0; i < 26; i++) {
                scores.put((char)(i+'a'), score[i]);
            }
            int[] freq = getFreq(letters);
            HashMap<String, Integer> wordScore = new HashMap();
            for (String w: words) {
                int temp = 0;
                for (char c: w.toCharArray()) {
                    temp += scores.get(c);
                }
                wordScore.put(w, temp);
            }
            solve(words, freq, wordScore, 0, 0);
            return ans;
        }
        
        private int[] getFreq(char[] s) {
            int[] ret = new int[26];
            for (char c: s) {
                ret[c-'a']++;
            }
            return ret;
        }
        
        private void solve(String[] words, int[] freq, HashMap<String, Integer> wordScore, int ind, int prev) {
            if (prev > ans) {
                ans = prev;
            }
            for (int i = ind; i < words.length; i++) {
                int[] cur = getFreq(words[i].toCharArray());
                if (canBeAdd(cur, freq)) {
                    for (int j = 0; j < 26; j++) {
                        freq[j] -= cur[j];
                    }
                    solve(words, freq, wordScore, i+1, prev+wordScore.get(words[i]));
                    for (int j = 0; j < 26; j++) {
                        freq[j] += cur[j];
                    }
                }
            }
            
            
        }
        
        
        private boolean canBeAdd(int[] word, int[] freq) {
            for (int i = 0; i< 26; i++) {
                if (word[i] > freq[i]) return false;
            }
            return true;
        }
    }
}