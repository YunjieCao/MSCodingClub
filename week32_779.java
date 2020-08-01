public class week32_779 {
    class Solution {
        public int kthGrammar(int N, int K) {
            if (N == 1) return 0;
            int prev = kthGrammar(N-1, (K+1)/2);
            if (K % 2 != 0) {// left
                if (prev == 0) {
                    return 0;
                } else {
                    return 1;
                }
            } else {
                if (prev == 0) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }
    }
}