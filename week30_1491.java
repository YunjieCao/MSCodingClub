public class week30_1491 {
    class Solution {
        public double average(int[] salary) {
            int sum = 0;
            int n = salary.length;
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int sal: salary) {
                min = Math.min(min, sal);
                max = Math.max(max, sal);
                sum += sal;
            }
            return (double)(sum-min-max) / (double)(n-2);
        }
    }
}