public class week30_164 {
    class Solution {
        class Bucket {
            int start;
            int end;
            boolean ifElement;
            public Bucket() {
                start = Integer.MAX_VALUE;
                end = Integer.MIN_VALUE;
                ifElement = false;
            }
        }
        public int maximumGap(int[] nums) {
            int n = nums.length;
            if (n < 2) return 0;
            int ret = 0;
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            for (int num: nums) {
                min = Math.min(min, num);
                max = Math.max(max, num);
            }
            if (min == max) return 0;
            long avgGap = ((long)(max) - (long)(min)) / (n - 1) + 1;
            Bucket[] buckets = new Bucket[n+1];
            for (int num: nums) {
                int ind = (int)(((long)(num) - (long)(min)) / avgGap);
                if (buckets[ind] == null) buckets[ind] = new Bucket();
                buckets[ind].start = Math.min(buckets[ind].start, num);
                buckets[ind].end = Math.max(buckets[ind].end, num);
                buckets[ind].ifElement = true;
            }
            int prev = -1, end = -1;
            boolean ifStart = false;
            for (int i = 0; i <= n; i++) {
                if (buckets[i] != null) {
                    // System.out.println(buckets[i].start + " " + buckets[i].end);
                    if (ifStart) {
                        ret = Math.max(ret, buckets[i].start - prev);
                    } else {
                        ifStart = true;
                    }
                    ret = Math.max(ret, buckets[i].end - buckets[i].start);
                    prev = buckets[i].end;
                } else {
                    continue;
                }
            }
            return ret;
        }
    }
}