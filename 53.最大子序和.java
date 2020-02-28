/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子序和 
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组
 * （子数组最少包含一个元素），返回其最大和。
 * 
 * 方法1动态规划: 转移方程：dp[i] = max(dp[i - 1], 0) + nums[i]
 * 方法2 贪心: 从头开始，累加和，并用Max函数记录最大值，当累加的和为负数时，
 * 舍弃之前所有，因为之前的不能参与到最大的计算了。
 */

// @lc code=start
class Solution {

    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (sum < 0) {
                sum = 0;
            }
            sum += nums[i];
            if (sum < 0) {
                sum = nums[i];
            }
            res = Math.max(sum, res);
        }

        return res;
    }

}
// @lc code=end
