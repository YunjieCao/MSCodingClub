public class week28_1025 {
    class Solution {
        Boolean[] cache;
        public boolean divisorGame(int N) {
            cache = new Boolean[N+1];
            return dfs(N);
        }
        private boolean dfs(int n) {
            if (n <= 1) return false;
            if (cache[n] != null) return cache[n];
            cache[n] = false;
            for (int i = 1; i*i <= n; i++) {
                if (n % i == 0) {
                    if (!dfs(n-i)) {
                        cache[n] = true;
                        break;
                    }
                    if ((i!= 1) && (!dfs(n-(n/i)))) {
                        cache[n] = true;
                        break;
                    }
                }
            }
            return cache[n];
        }
    }
}