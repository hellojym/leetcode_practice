/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int l = strs[0].length();
        for (String s : strs) {
            l = Math.min(l, s.length());
        }
        for (int i = 0; i < l; i++) {
            char temp = strs[0].charAt(i);
            for (String s : strs) {
                if (s.charAt(i) != temp) {
                    return sb.toString();
                }
            }
            sb.append(temp);
        }
        return sb.toString();
    }
}
// @lc code=end
