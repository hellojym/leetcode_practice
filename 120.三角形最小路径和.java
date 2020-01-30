import java.util.List;

/*
 * @lc app=leetcode.cn id=120 lang=java
 *
 * [120] 三角形最小路径和
 */

// @lc code=start
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        // 动态规划
        int row = triangle.size();
        int[] minlen = new int[row + 1];
        for (int level = row - 1; level >= 0; level--) {
            for (int i = 0; i <= level; i++) { // 第i行有i+1个数字
                minlen[i] = Math.min(minlen[i], minlen[i + 1]) + triangle.get(level).get(i);
            }
        }
        return minlen[0];
    }

    // 回溯，超时
    // private void backTrace(int sum, int row, int col, List<List<Integer>>
    // triangle) {
    // if (row >= length) {
    // return;
    // }
    // int value = triangle.get(row).get(col);
    // sum += value;
    // if (row == length - 1) {
    // if (sum < min) {
    // min = sum;
    // }
    // } else {
    // backTrace(sum, row + 1, col, triangle);
    // backTrace(sum, row + 1, col + 1, triangle);
    // }
    // }
}
// @lc code=end
