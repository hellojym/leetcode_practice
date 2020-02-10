/*
 * @lc app=leetcode.cn id=151 lang=java
 *
 * [151] 翻转字符串里的单词
 * 
 * 还可以用栈的思路，根据空格将从前到后的单词加入到栈中，之后倒出来并加上空格就好了。
 * 
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {

        String sb = reverse(s);
        sb = sb + " ";

        StringBuilder res = new StringBuilder();

        // eulb si yks eht
        boolean flag = true;
        int l = 0, r = 0;
        for (int j = 0; j < sb.length(); j++) {

            if (sb.charAt(j) == ' ') {
                if (flag) {
                    continue;
                }
                flag = true;
                String temp = sb.substring(l, r + 1);
                if (!temp.equals(" ")) {
                    res.append(reverse(temp)).append(" ");
                }
                continue;
            } else {
                if (flag) {
                    l = j;
                    r = j;
                } else {
                    r = j;
                }
                flag = false;

            }
        }
        if (res.length() == 0) {
            return "";
        }

        return res.substring(0, res.length() - 1).toString();

    }

    private String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
// @lc code=end
