/*
 * @lc app=leetcode.cn id=547 lang=java
 *
 * [547] 朋友圈
 * 【1 0 1 1 0 0 1
 *     1 0 0 1 0 1
 *       0 0 0 1 1
 *         0 0 1 0
 *           1 0 0
 *             0 1
 *               1
 * 
 * 该矩阵是无向图的邻接矩阵，采用DFS即可，笨办法是遍历矩阵，对每个结点进行dfs，但这样会导致两层遍历，时间复杂度n方*dfs
 * 假想有1，4，5，6，8，9这几个结点，为了寻找他们被分成了几组，也就是无向连通图的个数，遍历结点即可，对每个结点进行深搜。
 */

// @lc code=start
class Solution {

    public int findCircleNum(int[][] M) {
        // 保存已经被访问过的结点
        int visited[] = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            // 如果该结点没有被访问，对其进行dfs，并count++
            if (visited[i] == 0) {
                dfs(M, visited, i);
                count++;
            }
        }

        return count;
    }

    // 注意理解这里如何对矩阵形式的结点搜索的
    private void dfs(int[][] M, int[] visited, int i) {
        // i确定的情况下，可以理解成行号确定了，遍历该行的所有矩阵点，每发现一个==1的即说明这个矩阵点的列号对应的结点是其连通结点
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }

    // 如果不抽象出结点模型，直接遍历矩阵而不是遍历结点，时间复杂度太高

    // int[][] indexs;
    // public int findCircleNum(int[][] M) {
    // int row = M.length;
    // int col = M[0].length;
    // indexs = new int[row][col];
    // int count = 0;

    // for (int i = 0; i < row; i++) {
    // if (M[i][0] == 1 && indexs[i][0] == 0) {
    // count++;
    // }
    // travel(0, i, M);
    // }

    // return count;
    // }
    //
    // private void travel(int r, int c, int[][] table) {
    // indexs[r][c] = 1;
    // for (int m = 0; m < table.length; m++) {
    // if (table[m][c] == 1 && indexs[m][c] == 0) {
    // travel(m, c, table);
    // }
    // }

    // for (int n = 0; n < table[0].length; n++) {
    // if (table[r][n] == 1 && indexs[r][n] == 0) {
    // travel(r, n, table);
    // }
    // }
    // }
}
// @lc code=end
