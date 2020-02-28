/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] x 的平方根
 */

// @lc code=start
class Solution {
    public int mySqrt(int x) {
        if (x < 1) {
            return 0;
        }
        if (x < 4) {
            return 1;
        }
        long l = 0;
        long r = x;
        while (l < r) {
            long mid = (l + r) / 2;
            if ((mid * mid) == x) {
                return (int) mid;
            }
            if (mid == l) {
                return (int) mid;
            }
            if ((mid * mid) > x) {
                r = mid;
            } else {
                l = mid;
            }
        }
        return (int) l;
    }
}
// @lc code=end
