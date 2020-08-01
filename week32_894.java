public class week32_894 {
    /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    HashMap<Integer, List<TreeNode>> cache = new HashMap<>();
    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> ret = new ArrayList<>();
        if (N == 0) {
        } else if (N == 1) {
            ret.add(new TreeNode(0));
        } else {
            if (cache.containsKey(N)) return cache.get(N);
            // nodes on left subtree
            for (int i = 1; i < N-1; i+=2) {
                List<TreeNode> left = allPossibleFBT(i);
                List<TreeNode> right = allPossibleFBT(N-i-1);
                if (left.size() > 0 && right.size() > 0) {
                    for (TreeNode l: left) {
                        for (TreeNode r: right) {
                            TreeNode root = new TreeNode(0);
                            root.left = l;
                            root.right = r;
                            ret.add(root);
                        }
                    }
                }
            }
            cache.put(N, ret);
        }
        return ret;
    }
}
}