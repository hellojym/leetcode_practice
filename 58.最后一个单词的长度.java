/*
 * @lc app=leetcode.cn id=58 lang=java
 *
 * [58] 最后一个单词的长度
 */

// @lc code=start
class Solution {
    public int lengthOfLastWord(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int length = 0;
        boolean first = true;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (first && s.charAt(i) == ' ') {
                continue;
            } else if (!first && s.charAt(i) == ' ') {
                break;
            } else {
                length++;
                first = false;
            }
        }
        return length;
    }
}
// @lc code=end
