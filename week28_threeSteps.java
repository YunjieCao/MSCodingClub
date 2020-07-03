public class week28_threeSteps {
    class Solution {
        public int waysToStep(int n) {
            if (n == 1) return 1;
            if (n == 2) return 2;
            int[] dp = new int[n+1];
            int mod = 1000000007;
            dp[0] = 1;
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 3; i <= n; i++) {
                dp[i] = ((((dp[i-1] % mod) + (dp[i-2] % mod)) % mod) + (dp[i-3] % mod))%mod;
            }
            return dp[n];
        }
    }
}