import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {

        int sum = 0;
        int summit = 0;
        int index = 0;
        // 查找第一个峰值
        while (height[index] == 0 && height[index] <= height[index + 1]) {
            index++;
        }
        summit = index;
        while (index < height.length) {
            index++;
            if (height[index] < height[summit]) {
                continue;
            }
            if (height[index] >= height[summit]) {
                sum += calculateArea(height, summit, index);
                summit = index;
            }
        }
    }

    private int calculateArea(int[] height, int left, int right) {
        return 0;
    }
}
// @lc code=end
