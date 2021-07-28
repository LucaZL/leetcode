public class second {
    public static void main(String[] args) {

        ListNode l1 = new ListNode(2);
        ListNode l1_2 = new ListNode(4);
        ListNode l1_3 = new ListNode(3);
        l1.next = l1_2;
        l1_2.next = l1_3;

        ListNode l2 = new ListNode(5);
        ListNode l2_2 = new ListNode(6);
        ListNode l2_3 = new ListNode(4);
        l2.next = l2_2;
        l2_2.next = l2_3;

        ListNode l3 = addTwoNumbers(l1, l2);
        while(l3 != null) {
            System.out.print(l3.val + ",");
            l3 = l3.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultNode = new ListNode(0);
        ListNode parentNode = resultNode;
        int jinwei = 0;
        while(l1!=null || l2!= null) {
            int first_num = l1==null? 0 : l1.val;
            int second_num = l2==null? 0 : l2.val;
            int sum = first_num + second_num + jinwei;
            jinwei = sum / 10;
            parentNode.next = new ListNode(sum % 10);
            parentNode = parentNode.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        if(jinwei > 0) {
            parentNode.next = new ListNode(jinwei);
        }
        return resultNode.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
