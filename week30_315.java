import java.util.*;
public class week30_315 {
    class Solution {
        class Node {
            int num;
            int id;
            public Node(int num, int id) {
                this.num = num;
                this.id = id;
            }
        }
        public List<Integer> countSmaller(int[] nums) {
            int n = nums.length;
            int[] ret = new int[n];
            Node[] nodes = new Node[n];
            for (int i = 0; i < n; i++) {
                nodes[i] = new Node(nums[i], i);
            }
            mergeSort(nodes, 0, n-1, ret);
            List<Integer> ans = new ArrayList<>();
            for (int r: ret) {
                ans.add(r);
            }
            return ans;
        }
        
        private Node[] mergeSort(Node[] cur, int start, int end, int[] ret) {
            if (start > end) return new Node[0];
            if (start == end) {
                Node[] r = new Node[1];
                r[0] = cur[start];
                return r;
            }
            int mid = start + (end-start) / 2;
            Node[] left = mergeSort(cur, start, mid, ret);
            Node[] right = mergeSort(cur, mid+1, end, ret);
            int llen = left.length, rlen = right.length;
            Node[] ans = new Node[llen+rlen];
            int ptrl = 0, ptrr = 0;
            int count = 0;
            int ptr = 0;
            while (ptrl < llen && ptrr < rlen) {
                Node l = left[ptrl];
                Node r = right[ptrr];
                if (l.num <= r.num) {
                    ret[l.id] += count;
                    ans[ptr] = l;
                    ptrl ++;
                } else {
                    ans[ptr] = r;
                    ptrr ++;
                    count ++;
                }
                ptr ++;
            }
            while (ptrl < llen) {
                Node l = left[ptrl];
                ret[l.id] += count;
                ans[ptr] = l;
                ptrl ++;
                ptr ++;
            }
            while (ptrr < rlen) {
                ans[ptr ++] = right[ptrr++];
            }
            return ans;
            
        }
    }
}