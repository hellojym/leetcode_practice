/*
 * @lc app=leetcode.cn id=62 lang=java
 *
 * [62] 不同路径
 * 
 * 本质：杨辉三角 组合
 */

// @lc code=start
class Solution {
    int count = 0;

    public int uniquePaths(int m, int n) {
        // if (m == 1 && n == 1) {
        //     return 1;
        // }
        // if (m > 1) {
        //     trace(m - 1, n);
        // }
        // if (n > 1) {
        //     trace(m, n - 1);
        // }
        // return count;

        int[] cur = new int[n];
        Arrays.fill(cur,1);
        for (int i = 1; i < m;i++){
            for (int j = 1; j < n; j++){
                cur[j] += cur[j-1] ;
            }
        }
        return cur[n-1];
    }

    private void trace(int l, int m) {
        if (l == 1 && m == 1) {
            count++;
            return;
        }
        if (l > 1) {
            trace(l - 1, m);
        }
        if (m > 1) {
            trace(l, m - 1);
        }
    }
}
// @lc code=end
