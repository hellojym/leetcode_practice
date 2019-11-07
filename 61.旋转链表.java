/*
 * @lc app=leetcode.cn id=61 lang=java
 *
 * [61] 旋转链表
 * 
 * 特殊情况贼多
 * k==0 单个节点，0个节点，都返回自身
 * 另外，还要注意当k == 链的长度时，旋转了一圈相当于没转，直接返回head即可
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        if (k == 0) {
            return head;
        }

        ListNode p1 = head;
        ListNode p2 = head;
        ListNode pre = head;
        ListNode pre2 = head;

        int m = k;
        while (m != 0) {
            pre2 = p2;
            p2 = p2.next;
            if (p2 == null) {
                p2 = head;
            }
            m--;
        }
        if (p2 == p1) {
            return head;
        }
        while (p2 != null) {
            pre2 = p2;
            p2 = p2.next;
            pre = p1;
            p1 = p1.next;
        }

        pre.next = null;
        pre2.next = head;

        return p1;

    }
}
// @lc code=end
