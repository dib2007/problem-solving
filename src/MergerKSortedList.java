import java.util.Comparator;
import java.util.PriorityQueue;

public class MergerKSortedList {

    //https://leetcode.com/problems/merge-k-sorted-lists/submissions/

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        ListNode result = null;
        ListNode temp = null;
        for (ListNode listNode : lists) {
            if(listNode != null) heap.add(listNode);
        }
        while (!heap.isEmpty()) {
            ListNode min = heap.poll();
            if (result == null) {
                result = min;
                temp = min;
            } else {
                temp.next = min;
                temp = temp.next;
            }
            if (min.next != null) {
                heap.add(min.next);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MergerKSortedList obj = new MergerKSortedList();
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(5);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(4);

        ListNode head3 = new ListNode(2);
        head3.next = new ListNode(6);

        ListNode[] list = new ListNode[]{null};
        System.out.println(obj.mergeKLists(list));
    }
}
