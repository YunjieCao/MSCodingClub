public class week31_q2 {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int ret = n;
        for (int i = 0; i < n; i++) {
            ret ^= i;
            ret ^= nums[i];
        }
        return ret;
    }
}