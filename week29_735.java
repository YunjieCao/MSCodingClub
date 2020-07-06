import java.util.*;
public class week29_735 {
    class Solution {
        public int[] asteroidCollision(int[] asteroids) {
            List<Integer> list = new ArrayList<>();
            Stack<Integer> st = new Stack<>();
            for(int a: asteroids) {
                if (a > 0) {
                    st.push(a);
                } else {
                    boolean ifExplode = false;
                    while (!st.isEmpty()) {
                        int rightA = st.peek();
                        int curA = Math.abs(a);
                        if (rightA < curA) {
                            st.pop();
                        } else if (rightA == curA) {
                            st.pop();
                            ifExplode = true;
                            break;
                        } else {
                            ifExplode = true;
                            break;
                        }
                    }
                    if (!ifExplode) {
                        list.add(a);
                    }
                }
            }
            for (Integer i: st) {
                list.add(i);
            }
            int[] ret = new int[list.size()];
            for (int i = 0; i < ret.length; i++) {
                ret[i] = list.get(i);
            }
            return ret;
        }
    }
}