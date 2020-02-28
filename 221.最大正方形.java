/*
 * @lc app=leetcode.cn id=221 lang=java
 *
 * [221] 最大正方形
 * 
 * 动态归纳法
 */

// @lc code=start
class Solution {
    int width;
    int height;
    int max = 0;

    public int maximalSquare(char[][] matrix) {
        width = matrix[0].length;
        height = matrix.length;

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                max = (int) Math.max(max, Math.pow(checkPoint(i, j, matrix), 2f));
            }
        }
        return max;
    }

    private int checkPoint(int row, int col, char[][] matrix) {
        int i = 1;
        while (true) {
            for (int m = 0; m < i; m++) {
                if (col + i > width || matrix[row + m][col + i] == 0) {
                    return i;
                }
            }
            for (int m = 0; m < i; m++) {
                if (row + i > height || matrix[row + i][col] == 0) {
                    return i;
                }
            }
            i++;
        }

    }
}
// @lc code=end
