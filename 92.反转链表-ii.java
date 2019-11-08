/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        if (m == n) {
            return head;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        ListNode start;
        ListNode end;
        if (m == 1) {
            start = null;
            p2 = p2.next;
        } else {
            for (int i = 1; i < m - 1; i++) {
                p1 = p1.next;
                p2 = p2.next;
            }
            start = p1;
            p1 = p1.next;
            p2 = p2.next.next;
        }
        end = p1;
        for (int j = m - 1; j < n - 1; j++) {
            ListNode ptemp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = ptemp;
        }
        if (start != null) {
            start.next = p1;
            end.next = p2;
            return head;
        } else {
            end.next = p2;
            return p1;
        }

    }
}
// @lc code=end
