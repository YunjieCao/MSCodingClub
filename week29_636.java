import java.util.*;
public class week29_636 {
    class Solution {
        class Task {
            int id;
            int start;
            int time;
            public Task(int id, int start) {
                this.id = id;
                this.start = start;
            }
        }
        public int[] exclusiveTime(int n, List<String> logs) {
            int[] ret = new int[n];
            Stack<Task> st = new Stack<>();
            for (String log: logs) {
                String[] parts = log.split(":");
                int id = Integer.parseInt(parts[0]);
                int time = Integer.parseInt(parts[2]);
                if (parts[1].equals("start")) {
                    if (!st.isEmpty()) {
                        Task t = st.peek();
                        t.time += time-t.start;
                    }
                    Task newTask = new Task(id, time);
                    st.push(newTask);
                } else {
                    Task doneTask = st.pop();
                    doneTask.time += time - doneTask.start + 1;
                    ret[doneTask.id] += doneTask.time;
                    if (!st.isEmpty()) {
                        st.peek().start = time + 1;
                    }
                }
            }
            return ret;
        }
    }
}