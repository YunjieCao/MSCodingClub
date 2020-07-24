public class week31_q1 {
    public int maximum(int a, int b) {
        long c = a;
        long d = b;
        int res = (int) ((Math.abs(c-d) + c + d)/2);
        return res;
    }
}