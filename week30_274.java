import java.util.*;
public class week30_274 {
    class Solution {
        public int hIndex(int[] citations) {
            int n = citations.length;
            Arrays.sort(citations);
            int left = 0;
            int right = n-1;
            int ret = 0;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                int midIndex = citations[mid];
                int atLeastH = n - mid;
                if (atLeastH > midIndex) {
                    left = mid + 1;
                } else if (mid - 1 >= 0 && citations[mid-1] >= n - mid + 1) {
                    right = mid - 1;
                } else {
                    return n - mid;
                }
            }
            return 0;
        }
    }
}