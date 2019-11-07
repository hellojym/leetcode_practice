/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第N个节点
 * 
 * 重点是特殊情况的处理，头节点，单个节点，删除的节点恰好是头部
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) {
            return null;
        }

        ListNode p1 = head;
        ListNode pre = new ListNode(0);
        pre.next = p1;
        ListNode p2 = head;
        for (int i = 0; i < n; i++) {
            p2 = p2.next;
        }

        while (p2 != null) {
            p2 = p2.next;
            pre = p1;
            p1 = p1.next;
        }

        pre.next = p1.next;
        p1.next = null;
        if (p1 == head) {
            return pre.next;
        } else {
            return head;
        }
    }
}
// @lc code=end
