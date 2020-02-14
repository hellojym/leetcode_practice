/*
 * @lc app=leetcode.cn id=695 lang=java
 *
 * [695] 岛屿的最大面积
 * [
 * 情况1:
 *   1 1 0 0 0
 *   1 1 0 0 0
 *   0 0 0 1 1
 *   0 0 0 1 1
 * 情况2:
 *   0 1
 *   1 1
 * ]
 * 
 * 逐点回溯，回溯法，遍历所有的位置，当访问到的位置为1并且这个位置之前没有被访问过，
 * 对该点进行回溯求其面积，并将面积与之前最大比较并保存更新最大值。
 * 利用一个索引数组记录当前点是否被访问过，可以只记录为1的点。
 * 
 * 关键是回溯时，要对其上下左右都进行判断，不能只判断右和下，会导致情况2不对。
 */

// @lc code=start
class Solution {
    private int maxArea = 0;
    private int temp = 0;
    private int indexs[][];

    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        indexs = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (indexs[i][j] == 0 && grid[i][j] == 1) {
                    temp = 0;
                    backTrace(i, j, grid);
                    maxArea = Math.max(temp, maxArea);
                }

            }
        }

        return maxArea;
    }

    private void backTrace(int r, int c, int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        indexs[r][c] = 1;
        temp++;
        if (r < row - 1 && grid[r + 1][c] == 1 && indexs[r + 1][c] == 0) {
            backTrace(r + 1, c, grid);
        }
        if (c < col - 1 && grid[r][c + 1] == 1 && indexs[r][c + 1] == 0) {
            backTrace(r, c + 1, grid);
        }

        if (r > 0 && grid[r - 1][c] == 1 && indexs[r - 1][c] == 0) {
            backTrace(r - 1, c, grid);
        }

        if (c > 0 && grid[r][c - 1] == 1 && indexs[r][c - 1] == 0) {
            backTrace(r, c - 1, grid);
        }

    }
}
// @lc code=end
