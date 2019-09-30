import java.util.ArrayList;
import java.util.List;

public class Number19 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode result = removeNthFromEnd(node5, 1);
        while(result!=null) {
            System.out.println("result="+result.val);
            result = result.next;
        }
    }

    private static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tempHead = new ListNode(0);
        tempHead.next = head;
        ListNode first = tempHead;
        ListNode second = tempHead;
        // the first need to move n+1
        for(int i=0;i<=n;i++) {
            first = first.next;
        }
        while(first!=null) {
            first = first.next;
            second = second.next;
        }
        second.next=second.next.next;
        return tempHead.next;

//        if(head.next==null) return null;
//        List<ListNode> list = new ArrayList();
//        list.add(head);
//        ListNode nextNode = head.next;
//        while(nextNode!=null) {
//            list.add(nextNode);
//            nextNode = nextNode.next;
//        }
//        int len = list.size();
//        if(len == n) {
//            return list.get(1);
//        }else if(n == 1) {
//            list.get(len - 2).next = null;
//        }else{
//            list.get(len - n - 1).next = list.get(len - n + 1);
//        }
//        return head;
    }

}

