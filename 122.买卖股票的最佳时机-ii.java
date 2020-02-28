/*
 * @lc app=leetcode.cn id=122 lang=java
 *
 * [122] 买卖股票的最佳时机 II
 * min 在下滑时随时更新，并且在转折点算局部利润。
 * max在上行时更新
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }

        int max = prices[0];
        int min = prices[0];
        int res = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] <= prices[i + 1]) {
                max = prices[i + 1];
            } else {
                if (i > 0 && prices[i] >= prices[i - 1]) {
                    res += (max - min);
                }
                min = prices[i + 1];
            }
        }

        //注意对最后做特殊判断
        if (prices[prices.length - 1] >= prices[prices.length - 2]) {
            res += (max - min);
        }

        return res;
    }
}
// @lc code=end
