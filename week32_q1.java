public class week32_q1 {
    // https://leetcode-cn.com/problems/diving-board-lcci/
    public static void main(String[] args) {
        int shorter = 1, longer = 2;
        int k = 3;
        if (k == 0) {

        } else if (shorter == longer) {
            // only one possible result
            System.out.println(k*shorter);
        } else {
            // i shorter, (k-i) longer
            // f(i) = i * shorter + (k-i) * longer = k * longer + (shorter-longer) * i
            int[] ret = new int[k+1];
            int ptr = 0;
            for (int i = k; i >= 0; i--) {
                ret[ptr] = k*longer + (shorter-longer) * i;
                ptr ++; 
            }
        }
    }
}