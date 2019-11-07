import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=78 lang=java
 * 
 * 解决思路：对于n个元素的数组，它的组合 = 第一个数 + 剩下的数字进行组合 和 没有第一个数 +
 *  剩下的数字组合
 * 递归的关键就是： 假设我们已知问题的答案，用一个递归函数表示出来。
 *
 * [78] 子集
 */

// @lc code=start
class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backTrace(nums, 0, new ArrayList<Integer>());
        return result;
    }


    /**
     * @param nums 原始数组
     * @param start 从第几个开始,前两个参数表示了我们要进行组合的数组是啥。
     * @param onePath 保存其中一种路径
     */
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
