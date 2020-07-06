import java.util.*;
public class week29_155 {
    class MinStack {
        Stack<Integer> st;
        Stack<Integer> minSt;
        /** initialize your data structure here. */
        public MinStack() {
            st = new Stack<>();
            minSt = new Stack<>();
        }
        
        public void push(int x) {
            st.push(x);
            if (minSt.isEmpty() || x <= minSt.peek()) {
                minSt.push(x);
            }
        }
        
        public void pop() {
            int popedEle = st.pop();
            if (popedEle == minSt.peek()) {
                minSt.pop();
            }
        }
        
        public int top() {
            return st.peek();
        }
        
        public int getMin() {
            return minSt.peek();
        }
    }
    
    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
}