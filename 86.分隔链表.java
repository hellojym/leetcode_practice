/*
 * @lc app=leetcode.cn id=86 lang=java
 *
 * [86] 分隔链表
 * 
 * 注意事项，可以用虚拟头节点
 * 多用几个变量，small,big,smallHead,bigHead
 * 注意最后的处理，smallHead和bigHead可能为null
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode smallHead = null;
        ListNode bigHead = null;
        ListNode small = null;
        ListNode big = null;
        ListNode p = head;
        while (p != null) {
            if (p.val < x) {
                if (small == null) {
                    small = p;
                    smallHead = small;
                } else {
                    small.next = p;
                    small = small.next;
                }
            } else {
                if (big == null) {
                    big = p;
                    bigHead = big;
                } else {
                    big.next = p;
                    big = big.next;
                }
            }
            p = p.next;
        }
        if (big != null) {
            big.next = null;
        }
        if (small != null) {
            small.next = bigHead;
            return smallHead;
        } else {
            return bigHead;
        }
    }
}
// @lc code=end
