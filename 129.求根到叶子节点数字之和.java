import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=129 lang=java
 *
 * [129] 求根到叶子节点数字之和
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {

    private int result = 0;

    public int sumNumbers(TreeNode root) {

        List<Integer> path = new ArrayList<>();
        path.add(root.val);
        traceBack(root, path);
        return result;
    }

    private void traceBack(TreeNode parent, List<Integer> onePath) {
        TreeNode left = parent.left;
        TreeNode right = parent.right;
        if (left == null && right == null) {
            result += getPathSum(onePath);
            return;
        } else if (left == null) {
            onePath.add(right.val);
            traceBack(right, onePath);
        } else if (right == null) {
            onePath.add(left.val);
            traceBack(left, onePath);
        } else {
            int index = onePath.size();
            onePath.add(left.val);
            traceBack(left, onePath);
            onePath.remove(index);
            onePath.add(right.val);
            traceBack(right, onePath);
        }
    }

    private int getPathSum(List<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i) * Math.pow(10, list.size() - i - 1);
        }
        return sum;
    }
}
// @lc code=end
