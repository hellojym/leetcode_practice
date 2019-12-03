
class Util {
    static void printList(ListNode node) {
        while (node != null) {
            System.out.println(node.val + "");
            node = node.next;
        }
    }

    static TreeNode createTree() {
        TreeNode node = new TreeNode(5);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(9);
        TreeNode node5 = new TreeNode(3);
        node.left = node1;
        node.right = node2;
        node1.left = node3;
        node3.left = node4;
        node2.left = node5;
        return node;
    }

    static ListNode createList() {
        ListNode node = new ListNode();
        node.val = 4;
        node.next = null;

        ListNode node1 = new ListNode();
        node1.val = 3;
        node1.next = node;

        ListNode node2 = new ListNode();
        node2.val = 6;
        node2.next = node1;

        ListNode node3 = new ListNode();
        node3.val = 6;
        node3.next = node2;

        ListNode node4 = new ListNode();
        node4.val = 1;
        node4.next = node3;

        ListNode node5 = new ListNode();
        node5.val = 2;
        node5.next = node4;

        return node5;
    }

}