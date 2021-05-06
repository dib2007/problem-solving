public class SumLinkedList {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode temp = null;
        int carry = 0;
        while(l1 != null && l2 != null) {
            if(result == null) {
                result = new ListNode();
                temp = result;
            } else {
                result.next = new ListNode();
                result = result.next;
            }
            int sum = l1.val + l2.val + carry;
            carry = sum/10;
            result.val = sum%10;
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode leftOver = null;
        if (l1 != null) {
            leftOver = l1;
        } else {
            leftOver = l2;
        }
        while(leftOver != null) {
            result.next = new ListNode();
            result = result.next;
            int sum = carry + leftOver.val;
            result.val = sum%10;
            carry = sum/10;
            leftOver = leftOver.next;
        }
        if(carry > 0) {
            result.next = new ListNode();
            result = result.next;
            result.val = carry;
        }
        return temp;
    }
}
