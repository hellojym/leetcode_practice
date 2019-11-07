import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 * 
 * 回溯：
 * 重点理解：多条路径，何时新建路径？递归函数的含义？参数怎么定？
 * 递归的关键就在于，问题是跟元素数量有关的，我们假设对于任意n，
 * 都知道n对应的解，这样就能把n的问题分解成n-1和1的解决办法
 */

// @lc code=start
class Solution {
    List<List<Integer>> res = new ArrayList<List<Integer>>();

    public List<List<Integer>> permute(int[] nums) {

        List<Integer> array = new ArrayList<Integer>();
        for (int num : nums) {
            array.add(num);
        }
        backTrace(array, new ArrayList<Integer>());
        return res;
    }

    /**
     * 要明确递归函数的含义：对current数组进行遍历
     * 递归的要义就在于：子问题和母问题结构相同，
     * 母问题在假设子问题已知的情况下，如何求解母问题
     * @param current
     * @param onePath 从全局来看，是所有解中的一条路径，对本函数来说，
     * 就是递归的上层传下来的路径
     */
    private void backTrace(List<Integer> current, List<Integer> onePath) {
        if (current.size() == 0) {
            res.add(onePath);
            return;
        }
    
        //求全排列的思路是：依次取当前数组的单个元素作为开头,对剩下的元素进行遍历。
        for (int i = 0; i < current.size(); i++) {
            List<Integer> newPath = new ArrayList<>(onePath);
            newPath.add(current.get(i));
            int value = current.remove(i);
            backTrace(current, newPath);
            current.add(i, value);
        }
    }

}
// @lc code=end
