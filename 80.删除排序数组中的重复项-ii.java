/*
 * @lc app=leetcode.cn id=80 lang=java
 *
 * [80] 删除排序数组中的重复项 II
 * 
 * 思路，index表示修正后的数组遍历index，i表示原来数组的index
 * dupcount 记录重复数量，根据该值判断是否要把i对应的元素移动到index上来
 * 
 * 注意当重复元素 > 1以后，都要移动
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        int duplicatedCount = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[index] != nums[i]) {
                nums[index] = nums[i];
                duplicatedCount = 0;
                if (duplicatedCount > 1) {
                    index++;
                }
                continue;
            } else {
                // 重复数量<=1，正常处理
                if (duplicatedCount <= 1) {
                    index++;
                    nums[index] = nums[i];
                    duplicatedCount++;
                    continue;
                } else {
                    // dupicatedCount++ ;
                    continue;
                }
            }

        }
        if (duplicatedCount > 1) {
            return index;
        } else {
            return index + 1;
        }
    }
}
// @lc code=end
