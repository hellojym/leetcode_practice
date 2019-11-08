/*
 * @lc app=leetcode.cn id=141 lang=java
 *
 * [141] 环形链表
 * 是否存在环 
 * solution： 快慢指针,注意点：循环的种植条件是快指针是否为null
 */

// @lc code=start
/**
 * Definition for singly-linked list. class ListNode { int val; ListNode next;
 * ListNode(int x) { val = x; next = null; } }
 */
class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
            if (p2 != null) {
                p2 = p2.next;
            } else {
                return false;
            }
            if (p1 == p2) {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end
