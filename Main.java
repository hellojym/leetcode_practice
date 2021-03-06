import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Main {

    public static void main(String[] args) {
        System.out.println("-------------main begin---------------");
        System.out.println("-----------------------");
        int array[] = { 4, 3, 1, 6, 6, 8, 7 };
        new QuickSort().quickSort(array);
        for (int i : array) {
            System.out.println(i);
        }
        System.out.println("--------------main end----------------");

    }

    public static void printArray(int[] nums) {
        for (int i : nums) {
            System.out.println(i);
        }
    }

    public static void printList(ListNode list) {
        while (list != null) {
            System.out.println(list.val);
            list = list.next;
        }

    }

    public static ListNode createList(int[] nums) {
        ListNode pre = null;
        ListNode head = null;
        for (int i : nums) {
            ListNode node = new ListNode(i);
            if (pre != null) {
                pre.next = node;
            } else {
                head = node;
            }
            pre = node;
        }
        return head;
    }
}