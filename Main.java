import java.awt.List;

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
        // Solution1 solution = new Solution1();
        // int [] nums = {-3,-2,-5,3,4};
        // solution.threeSumClosest(nums , -1);
        // int max = Integer.MAX_VALUE;
        // System.out.println(max);
        // System.out.println(Math.pow(2, 31));
        // Solution3 solu = new Solution3();
        // int [] a = {1,2,3};
        // solu.permute(a);
        // for (List<Integer> i : list) {
        // // System.out.println(i.toString());
        // for (Integer j : i) {
        // System.out.println(j.toString());
        // }
        // }
        // int[] array = { 1, 4, 5, 2, 5, 2 };
        Solution4 solution4 = new Solution4();
        int [][] origin = {{1,3},{2,6},{8,10},{15,18}};
        solution4.merge(origin);
        // ListNode node = createList(array);
        // ListNode result = solution4.partition(node, 3);
        // printList(result);

    }
}