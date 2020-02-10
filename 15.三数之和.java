import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 * 三数之和==0，说明至少有一正一负，除非存在3个0
 * 先排序，然后通过遍历固定一个数，另外两个采用双指针。
 * 为了避免重复，需要判断双指针移动时是否与相邻的相同，相同则跳过。
 * 
 * 跟最接近三数之和解法相同。核心思想：1.双指针 2，固定一个(遍历)
 * 
 * [-5，-3，-1，0，2，5，7，8, 10]
 * [-4, -1, -1, 0, 1, 2]
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        int l, r;
        if (nums == null || len < 3)
            return res;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > 0) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            l = i + 1;
            r = len - 1;
            int target = 0 - nums[i];
            while (l < r) {
                if (nums[l] + nums[r] > target) {
                    r--;
                } else if (nums[l] + nums[r] < target) {
                    l++;
                } else {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1])
                        l++; // 去重
                    while (l < r && nums[r] == nums[r - 1])
                        r--; // 去重
                    l++;
                    r--;
                }
            }
        }
        return res;
    }
}
// @lc code=end
