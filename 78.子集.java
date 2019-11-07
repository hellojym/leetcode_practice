import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

// @lc code=start
class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backTrace(nums, 0, new ArrayList());
        return result;
    }

    private void backTrace(int[] nums, int start, List<Integer> onePath) {
        if (start == nums.length) {
            result.add(onePath);
            return;
        }
        List<Integer> pathNew = new ArrayList<>(onePath);
        // 不包含i的
        backTrace(nums, start + 1, onePath);
        // 包含i
        pathNew.add(nums[start]);
        backTrace(nums, start + 1, pathNew);
    }
}
// @lc code=end
