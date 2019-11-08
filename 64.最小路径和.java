/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 * 动态规划，注意状态转移方程
 * 对本题来说，在矩阵的右边和下边的是比较特殊的，共需要分四类讨论：
 * 1.右下角 2.右边 3.底边 4.普通点
 * 但是其实它们都有一个共同点：
 *     当前点的最小路径值 = 当前点的值 + 剩下点的最小路径值
 * 因此，我们只需要确定上面4个分类的剩下点路径值
 * 
 * 总结一下动态规划，它其实跟回溯是反着来的，回溯是假设我们直到子问题，我们递归的
 * 从外向内，直到递归终结点。而动态规划则是从回溯的最后“递归终结点”开始，反着向外走，
 * 并且把每一步的结果保存到一个数据结构中，通过循环，依次从里向外扩展，直到所有的解
 * 都出来。
 */

// @lc code=start
class Solution {
    // m 行 n 列
    // i j
    int m, n;
    int[][] min;

    public int minPathSum(int[][] grid) {
        m = grid.length - 1;
        n = grid[0].length - 1;
        min = new int[m + 1][n + 1];
        for (int i = m; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {
                min[i][j] = minPath(i, j, grid);
            }
        }

        return min[0][0];

    }

   /**
    * 动态规划，转移方程
    * 
    * @param i
    * @param j
    * @param grid
    * @return
    */
    private int minPath(int i, int j, int[][] grid) {
        int subMin;
        if (i == m && j == n) {
            subMin = 0;
        } else if (j < n && i < m) {
            subMin = Math.min(min[i + 1][j], min[i][j + 1]);
        } else if (j == n) {
            subMin = min[i + 1][j];
        } else {
            subMin = min[i][j + 1];
        }
        return grid[i][j] + subMin;
    }

    // /**
    // * 暴力回溯法，时间复杂度太高
    // */
    // private int path(int[][] grid, int i, int j) {
    // int cur = grid[i][j];
    // if (i == m && j == n) {
    // return cur;
    // }
    // if (i == m && j != n) {
    // return cur + path(grid, i, j + 1);
    // }
    // if (i != m && j == n) {
    // return cur + path(grid, i + 1, j);
    // } else {
    // int right = path(grid, i + 1, j);
    // int bottom = path(grid, i, j + 1);
    // if (right < bottom) {
    // return cur + right;
    // } else {
    // return cur + bottom;
    // }
    // }

    // }
}
// @lc code=end
