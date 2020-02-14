/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 * tar 1
 * 9，1，2, 3, 4, 5
 * 6，7，9，0，1，
 * 
 * 4,5,6,7,0,1,2
 * 3
 * 
 * 情况比较多，需要分类讨论
 * 注意临界条件已经数组边界
 * 
 * 还有一种方法，先查找旋转点，然后在单个区间二分查找.
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int first = nums[0];
        int l = 0;
        int r = nums.length - 1;
        if (target == first) {
            return 0;
        }
        if (target == nums[nums.length - 1]) {
            return nums.length - 1;
        }
        // 目标在左边
        if (target > first) {
            while (r > l + 1) {
                int midIndex = (l + r) / 2;
                int mid = nums[midIndex];
                if (mid == target) {
                    return midIndex;
                }
                // 中间值落到了左边
                if (mid > first) {
                    if (mid > target) {
                        r = midIndex;
                    } else {
                        l = midIndex;
                    }
                }
                // 中间值落到了右边
                else {
                    r = midIndex;
                }
            }
        }
        // 目标在右边
        else {
            while (r > l + 1) {
                int midIndex = (l + r) / 2;
                int mid = nums[midIndex];
                if (mid == target) {
                    return midIndex;
                }
                // 中间值落到了左边
                if (mid > first) {
                    l = midIndex;
                }
                // 中间值落到了右边
                else {
                    if (mid > target) {
                        r = midIndex;
                    } else {
                        l = midIndex;
                    }
                }
            }

        }

        return -1;

    }
}
// @lc code=end
