import java.util.List;

public class Number24 {
    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
//        node4.next = node5;

        ListNode result = swapPairs(node1);
        while(result!=null) {
            System.out.println("result="+result.val);
            result = result.next;
        }
    }

    private static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;


//        ListNode result = new ListNode(0);
//        result.next = head;
//        ListNode first = result;
//        while(first.next!=null && first.next.next!=null) {
//            ListNode mid = first.next.next;
//            first.next.next = first.next.next.next;
//            first
//            ListNode node1 = result.next;
//            ListNode node2 = node1.next;
//            first = node2.next;
//
//            node2.next = node1;
//            result_temp.next = node2;
//            result_temp = node1;
//        }
//
//        return result.next;
    }
}
