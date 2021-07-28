package other;

/**
 * @description:
 * @author: zhaolu
 * @createDate: 2021/7/4
 */
public class Test {

    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        ListNode root1 = new ListNode(1);

        while(root1 != null) {
            System.out.println(root1.val);
        }
    }

    private static ListNode reverse(ListNode root, int k) {
        ListNode head = new ListNode(0);
        ListNode result = head;
        int num = k;
        while(root != null) {
            ListNode temp = root.next;
            root = root.next;
            if(num > 0) {
                num--;
                temp.next = head.next;
                head.next = temp;
            }

            if(num == 0) {
                while(head.next != null) {
                    head = head.next;
                }
                num = k;
            }
        }
        return result;
    }

}


class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int val) {
        this.val = val;
    }
}
