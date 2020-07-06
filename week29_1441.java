import java.util.*;
public class week29_1441 {
    class Solution {
        public List<String> buildArray(int[] target, int n) {
            List<String> ret = new ArrayList<>();
            int ptr = 0;
            int l = target.length;
            for (int i = 1; i <= n; i++) {
                if (ptr == l) break;
                if (target[ptr] == i) {
                    ret.add("Push");
                    ptr ++;
                } else {
                    ret.add("Push");
                    ret.add("Pop");
                }
            }
            return ret;
        }
    }
}