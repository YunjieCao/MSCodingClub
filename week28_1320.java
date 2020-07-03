import java.util.*;
public class week28_1320 {
    class Solution {
        int[][][] dp;
        HashMap<Character, int[]> map;
        public int minimumDistance(String word) {
            char[] str = word.toCharArray();
            int n = str.length;
            if (n <= 2) return 0;
            dp = new int[27][27][301];
            for (int i = 0; i < 27; i++) {
                for (int j = 0; j < 27; j++) {
                    Arrays.fill(dp[i][j], -1);
                }
            }
            map = initBoard();
            
            return dfs(str, 0, 26, 26, n);
        }
        
        
        private int dfs(char[] word, int ind, int left, int right, int n) {
            if (ind == n) return 0;
            if (dp[left][right][ind] != -1) return dp[left][right][ind];
            
            int ret = Math.min(dfs(word, ind+1, word[ind]-'A', right, n) + getDist(left, word[ind]-'A'), 
                              dfs(word, ind+1, left, word[ind]-'A', n) + getDist(right, word[ind]-'A'));
            dp[left][right][ind] = ret;
            return ret;
        }
        
        
        private int getDist(int p, int c) {
            if (p == 26 || c == 26) return 0;
            char prev = (char)(p+'A'), cur = (char)(c+'A');
            int[] prevPos = map.get(prev);
            int[] curPos = map.get(cur);
            return Math.abs(prevPos[0]-curPos[0]) + Math.abs(prevPos[1]-curPos[1]); 
        }
        
        
        private HashMap<Character, int[]> initBoard() {
            HashMap<Character, int[]> map = new HashMap<>();
            for (char c = 'A'; c <= 'Z'; c++) {
                int row = (int)(c-'A') / 6;
                int col = (int)(c-'A') % 6;
                map.put(c, new int[]{row, col});
            }
            return map;
        }
    }
}