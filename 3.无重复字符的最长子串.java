/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 * 
 * 思路，滑动窗口，难点是如何判断当前窗口中是否有最新元素，思路有两个：
 * 1. 用hashMap保存当前窗口的所有字符，然后判断是否contains新value，复杂度较高
 * 2. 采用数组，数组的index对应字符char(等价于int)，value对应于当前char的最新index。
 * 
 * 所以思路来了，新建一个数组index，大小128，然后遍历，遍历时需要做三件事：
 * 1. 比较最新字符在index数组所对应的value值，如果大于窗口左边界，则说明当前
 * 窗口中已经存在当前字符，于是更新左边界
 * 2. 对于已经更新的窗口，取之前保存的ans和新窗口的最大值比较，并更新ans。
 * 3. 更新当前字符对应的索引值
 */

// @lc code=start
class Solution {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }

        int n = s.length(), ans = 0;
        // index数组保存了所有已经出现过的元素所在的最新位置。
        int[] index = new int[128];
        for (int k = 0; k < index.length; k++) {
            index[k] = -1;
        }
        index[s.charAt(0)] = 0;
        for (int j = 1, i = 0; j < n; j++) {
            char temp = s.charAt(j);
            if (index[temp] >= i) {
                //更新窗口左边缘
                i = index[temp] + 1;
            } 
            // 更新ans，取当前值和当前窗口的最大值
            ans = Math.max(ans, j - i + 1);
            // 无论什么情况，都更新当前char的索引
            index[temp] = j;

        }
        return ans;
    }
}
// @lc code=end
