/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 * 
 * 此题要注意，只需要遍历一次，保存最小峰值即可，计算当前点到最小峰值的差距，如果大于
 * 之前的最大值，则更新，否则继续遍历。不用保存之前的最大index。
 * 
 * 即在一趟遍历过程中，记录最小谷之后的最大差。不用担心之前最新的最小谷后面差距小于之前的。
 * 因为会取最值。 而且，最大差距只可能出现在遍历过程中，最小谷到最新index的差。
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int minIndex = 0;
        int max = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] >= prices[i - 1]) {
                max = Math.max(max, prices[i] - prices[minIndex]);
            } else {
                if (prices[i] < prices[minIndex]) {
                    minIndex = i;
                }
            }
        }
        return max;
    }
}
// @lc code=end
