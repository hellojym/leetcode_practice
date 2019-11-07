import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 * 
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
 * 找出 nums 中的三个整数，使得它们的和与 target 最接近。
 * 返回这三个数的和。假定每组输入只存在唯一答案。
 * 
 * solution： 现排序，然后双指针，时间复杂度 nlogn + n2 > n平方
 */

// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE / 2;

        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            int t = target - nums[i];
            while (j < k) {
                int sum = nums[j] + nums[k];
                res = Math.abs(sum + nums[i] - target) > Math.abs(res - target) ? res : sum + nums[i];
                if (sum < t) {
                    j++;
                } else if (sum > t) {
                    k--;
                } else {
                    return target;
                }
            }
        }

        return res;
    }
}
// @lc code=end
