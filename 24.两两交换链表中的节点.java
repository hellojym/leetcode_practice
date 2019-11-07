/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
 * 
 * 注意奇偶数两种情况,注意判断下两个节点是否存在
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode res = p2;
        while (p2 != null) {
            ListNode pnext = p2.next;

            p2.next = p1;
            if (pnext != null && pnext.next != null) {
                p1.next = pnext.next;
                p1 = pnext;
                p2 = pnext.next;
            } else if (pnext != null && pnext.next == null) {
                p1.next = pnext;
                pnext.next = null;
                break;
            } else {
                p1.next = null;
                break;
            }

        }

        return res;

    }
}
// @lc code=end
