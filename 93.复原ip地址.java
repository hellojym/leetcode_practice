import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=93 lang=java
 *
 * [93] 复原IP地址
 * 注意考虑遇到0的问题，0不能作为数字开头
 */

// @lc code=start
class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();

        backTrace(s, new ArrayList<>());

        for (List<Integer> item : res) {
            char[] array = s.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < array.length; i++) {
                if (item.contains(i)) {
                    sb.append(".");
                }
                sb.append(array[i]);
            }
            result.add(sb.toString());
        }

        return result;

    }

    private void backTrace(String s, List<Integer> path) {
        if (path.size() >= 3) {
            String last = s.substring(path.get(2), s.length());
            if (last.length() >= 0 && Integer.parseInt(last) <= 255) {
                res.add(path);
            }
        } else {
            int index;
            if (path.isEmpty()) {
                index = -1;
            } else {
                index = path.get(path.size() - 1);
            }

            for (int i = index + 1; i < index + 4 && i < s.length(); i++) {
                String temp = s.substring(index + 1, i + 1);
                if (Integer.parseInt(temp) <= 255) {
                    path.add(i);
                    backTrace(s, path);
                    path.remove(i);
                }

            }

        }

    }
}
// @lc code=end
