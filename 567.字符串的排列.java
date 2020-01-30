/*
 * @lc app=leetcode.cn id=567 lang=java
 *
 * [567] 字符串的排列
 * 
 * 理清题意，s2中有一个子串，是s1的一个排列，所以这个滑动窗口比较特别，它的长度是固定的。整体
 * 往右边移动
 * 另一个难点就是如何最快的判断一个串是另一个串的排列。
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] index = new int[128];
        for (int i = 0; i < s1.length(); i++) {
            index[s1.charAt(i)]++;
        }

        for (int i = 0, j = s1.length(); j < s2.length() + 1; i++, j++) {
            if (index[s2.charAt(i)] == 0) {
                continue;
            }
            String temp = s2.substring(i, j);
            if (containsAll(temp, index)) {
                return true;
            }
        }
        return false;
    }

    private boolean containsAll(String s, int[] all) {
        int[] index = new int[128];
        for (int i = 0; i < s.length(); i++) {
            index[s.charAt(i)]++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (index[s.charAt(i)] != all[s.charAt(i)]) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
