/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l;
        ListNode res = new ListNode(0);
        int t = l1.val + l2.val;
        res.val = t > 9 ? (t - 10) : t;
        l = res;
        int next = t > 9 ? 1 : 0;
        while (l1.next != null || l2.next != null) {
            l.next = new ListNode(0);
            l = l.next;
            if (l1.next != null && l2.next != null) {
                l1 = l1.next;
                l2 = l2.next;
                int temp = l1.val + l2.val + next;
                if (temp > 9) {
                    temp = temp - 10;
                    next = 1;
                } else {
                    next = 0;
                }
                l.val = temp;
            } else if (l1.next != null) {
                l1 = l1.next;
                int temp = l1.val + next;
                if (temp > 9) {
                    temp = temp - 10;
                    next = 1;
                } else {
                    next = 0;
                }
                l.val = temp;
            } else {
                l2 = l2.next;
                int temp = l2.val + next;
                if (temp > 9) {
                    temp = temp - 10;
                    next = 1;
                } else {
                    next = 0;
                }
                l.val = temp;
            }
        }
        if (next == 1) {
            l.next = new ListNode(0);
            l.next.val = 1;
        }
        return res;
    }

}
