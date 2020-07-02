public class week28_1139 {
    class Solution {
        public int largest1BorderedSquare(int[][] grid) {
            int n = grid.length;
            if (n == 0) return 0;
            int m = grid[0].length;
            if (m == 0) return 0;
            int[][][] dp = new int[n][m][4];
            int ret = 0;
            init(grid, dp, n, m);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == 1) {
                        int temp = 1;
                        for (int len = 2; ; len++) {
                            if (i-len+1 < 0 || j-len+1 < 0) break;
                            if (dp[i][j][1] >= len && dp[i][j][3] >= len && dp[i-len+1][j-len+1][2] >= len && dp[i-len+1][j-len+1][0] >= len ) {
                                temp = len;
                            }
                        }
                        ret = Math.max(ret, temp * temp);
                    }
                }
            }
            return ret;
        }
        
        private void init(int[][] grid, int[][][] dp, int n, int m) {
            //0: l->r 1: r->l 2: up->down 3:down->up
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == 0) {
                        dp[i][j][1] = 0;
                    } else {
                        dp[i][j][1] = j > 0? dp[i][j-1][1] + 1 : 1;
                    }
                    if (grid[i][m-1-j] == 0) {
                        dp[i][m-1-j][0] = 0;
                    } else {
                        dp[i][m-1-j][0] = j > 0? dp[i][m-j][0] + 1: 1;
                    }
                }
            }
            for (int j = 0; j < m; j++) {
                for (int i = 0; i < n; i++) {
                    if (grid[i][j] == 0) {
                        dp[i][j][3] = 0;
                    } else {
                        dp[i][j][3] = i > 0? dp[i-1][j][3] + 1: 1;
                    }
                    if (grid[n-1-i][j] == 0) {
                        dp[n-1-i][j][2] = 0;
                    } else {
                        dp[n-1-i][j][2] = i > 0? dp[n-i][j][2] + 1: 1;
                    }
                }
            }
        }
    }
}