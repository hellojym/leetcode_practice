/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 * 中心扩展法   
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        for (float i = 0f; i < s.length(); i += 0.5f) {
            String temp = getLongestFromCenter(s, i);
            if (temp.length() > res.length()) {
                res = temp;
            }
        }
        return res;
    }

    private String getLongestFromCenter(String s, float index) {
        int left;
        int right;
        String result;
        int intIndex = (int) index;
        if ((index - intIndex) == 0) {
            left = intIndex - 1;
            right = intIndex + 1;
            result = s.substring(intIndex, intIndex + 1);
        } else {
            left = intIndex;
            right = intIndex + 1;
            result = "";
        }

        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                result = s.charAt(left) + result + s.charAt(right);
            } else {
                break;
            }
            left--;
            right++;
        }

        return result;

    }
}
// @lc code=end
