
//https://leetcode.com/problems/remove-nth-node-from-end-of-list/
public class RemoveNthNode {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        for (int i=0;i<n;i++) {
            if (fast == null) return null;
            fast = fast.next;
        }
        if (fast == null) return head.next;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        if (slow.next != null) slow.next = slow.next.next;
        return head;
    }

    public static ListNode createList(int[] arr) {
        ListNode head = null;
        ListNode temp = null;
        for(int i : arr) {
            if(head == null) {
                head = new ListNode(i);
                temp = head;
            } else {
                temp.next = new ListNode(i);
                temp = temp.next;
            }
        }
        return head;
    }
    static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = createList(new int[]{1});
        printList(removeNthFromEnd(head, 1));
    }
}



