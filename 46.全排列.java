import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 * 
 * 回溯：
 * 重点理解：多条路径，何时新建路径？递归函数的含义？参数怎么定？
 */

// @lc code=start
class Solution {
    List<List<Integer>> res = new ArrayList();

    public List<List<Integer>> permute(int[] nums) {

        List<Integer> array = new ArrayList();
        for (int num : nums) {
            array.add(num);
        }
        for (int i = 0; i < array.size(); i++) {
            //可以从这里理解递归函数的意义
            backTrace(array, new ArrayList(), i);
        }
        return res;
    }

    /**
     * 递归函数,表示的含义：以index开头，剩下的进行排序。
     * @param current 当前列表中的所有数据
     * @param onePath 其中一条路径,保存该路径上所有的数据。
     * @param index 谁当开头元素
     */
    private void backTrace(List<Integer> current, List<Integer> onePath, int index) {

        // 递归终止条件
        if (current.size() == 1) {
            onePath.add(current.get(0));
            res.add(onePath);
            return;
        }
        // 将当前值保存到onePath列表中
        onePath.add(current.get(index));
        // 将当前值删掉
        int value = current.remove(index);
        // 从剩下的列表中继续递归
        for (int i = 0; i < current.size(); i++) {
            List<Integer> list = new ArrayList();
            list.addAll(onePath);
            backTrace(current, list, i);
        }
        current.add(index, value);

    }
}
// @lc code=end
