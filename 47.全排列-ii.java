import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 * 
 * 关键在于，如何“剪枝去重”
 * 我们的递归函数的定义是，确定一个头，对剩下的进行全排列。那么重复就会发生在
 * 这个头上，遍历当前数组时，如果发现选定的头之前选过，这个头应该跳过，因为头一样，
 * 这两个遍历会重复。
 */

// @lc code=start
class Solution {

    List<List<Integer>> res = new ArrayList<List<Integer>>();

    public List<List<Integer>> permuteUnique(int[] nums) {

        List<Integer> array = new ArrayList<Integer>();
        for (int num : nums) {
            array.add(num);
        }
        backTrace(array, new ArrayList<Integer>());
        return res;
    }

    private void backTrace(List<Integer> current, List<Integer> onePath) {
        if (current.size() == 0) {
            res.add(onePath);
            return;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < current.size(); i++) {
            if (map.get(current.get(i)) != null) {
                continue;
            }
            List<Integer> newPath = new ArrayList<>(onePath);
            newPath.add(current.get(i));
            int value = current.remove(i);
            backTrace(current, newPath);
            current.add(i, value);
            map.put(current.get(i), 1);
        }
    }

    // 这个方法太笨了，时间复杂度太高
    // /**
    // * 相比于非重复，增加一步验证
    // * @param path
    // * @return
    // */
    // private boolean checkRepeat(List<Integer> path) {
    // for (List<Integer> item : res) {
    // boolean same = true;
    // for (int j = 0;j<path.size();j++) {
    // if (path.get(j) != item.get(j)) {
    // same = false;
    // }
    // }
    // if (same) {
    // return true;
    // } else {
    // continue;
    // }
    // }
    // return false;
    // }
}
// @lc code=end
