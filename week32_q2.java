public class week32_q2 {
    public static void main(String[] args) {
        int A = 13, B = 10;
        int ans = 0;
        int i = 0;
        while (A > 0) {
            if ((A&1) != 0) {
                ans += (B << i);
            }
            A >>= 1;
            i ++;
        }
        System.out.println(ans);
    }
}