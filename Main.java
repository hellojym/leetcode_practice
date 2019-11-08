
class Main {

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

    public static void main(String[] args) {
        int[][] arr = {{1,2,3,}, {4,5,6}};
        Solution5 s = new Solution5();
        s.minPathSum(arr);
    }
}