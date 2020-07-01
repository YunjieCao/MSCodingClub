public class week28_464 {
    class Solution {
        Boolean[] cache;
        public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
            int n = maxChoosableInteger, m = desiredTotal;
            if (n >= m) return true;
            if ((1+n)*n/2 < m) return false;
            int l = 1 << n;
            cache = new Boolean[l+1];
            return dfs(0, 0, n, m);
        }
        
        private boolean dfs(int total, int mask, int n, int m) {
            if (total >= m) return false;// this player already lose
            if (cache[mask] != null) return cache[mask];
            cache[mask] = false;
            for (int i = 0; i < n; i++) {
                if (((1 << i) & mask) > 0) continue;
                if (!dfs(total+i+1, (1<<i)|mask, n, m)) { // next player lose, then this player win
                    cache[mask] = true;
                    break;
                }
            }
            return cache[mask];
        }
    }
}