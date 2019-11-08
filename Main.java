class Main {

    public static void main(String[] args) {
        System.out.println("-------------main begin---------------");
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