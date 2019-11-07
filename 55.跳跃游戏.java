import java.util.List;

/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 * 
 * 回溯会超时
 */

// @lc code=start
class Solution {

    private boolean has = false;

    private static final int GOOD = 10000;
    private static final int UNKNOWN = 10001;

    public boolean canJump(int[] nums) {
        return doCanJump(nums);
    }

    /**
     * 方法一：从右往左遍历每个节点，看各个节点能走过的路径中是否有“有效点”，其中有效点
     * 是指该点能到达终点。
     * @param nums
     * @return
     */
    private boolean doCanJump(int[] nums) {
        int l = nums.length;
        int[] memo = new int[l];

        for (int i = 0; i < l - 1; i++) {
            memo[i] = UNKNOWN;
        }
        memo[l - 1] = GOOD;

        for (int j = l - 2; j >= 0; j--) {
            int futherestIndex = Math.min(l - 1, j + nums[j]);
            for (int k = j + 1; k <= futherestIndex; k++) {
                if (memo[k] == GOOD) {
                    memo[j] = GOOD;
                    break;
                }
            }
        }
        return memo[0] == GOOD;
    }

    /**
     * 方法2:回溯法，时间复杂度太高,超时
     * 
     * @param index
     * @param nums
     */
    private void trace(int index, int[] nums) {
        if (index == nums.length - 1) {
            has = true;
            return;
        }
        if (index >= nums.length) {
            return;
        }
        int length = nums[index];
        for (int i = 1; i <= length; i++) {
            trace(index + i, nums);
        }
    }
}
// @lc code=end
