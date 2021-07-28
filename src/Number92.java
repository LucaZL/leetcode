/**
 * @description: 反转链表
 * @author: zhaolu
 * @createDate: 2021/3/18
 */

/**
 * 给你单链表的头节点 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *
 * 例：
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 *
 * 输入：head = [1,8,5,4,6], left = 3, right = 4
 * 输出：[1,8,4,5,6]
 */


import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class Number92 {
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        int count = 0;
        ListNode fixNode, endNode, startNode, secondNode = head;
        endNode = secondNode;
        startNode = secondNode;
        fixNode = secondNode;
        secondNode = secondNode.next;
        while(secondNode.next != null && count <= right) {
            count++;
            if(count < left) {
                fixNode = secondNode;
                secondNode = secondNode.next;
                continue;
            }
            if(count == left) {
                endNode = secondNode;
                startNode =  secondNode;
                secondNode = secondNode.next;
                endNode.next = null;
                continue;
            }
            if(count > left && count <= right) {
                ListNode temp = secondNode;
                secondNode = secondNode.next;
                temp.next = startNode;
                startNode = temp;
                continue;
            }
            if(count > right) {
                fixNode.next = startNode;
                endNode.next = secondNode;
                break;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode temp = null;
        for(int i=15;i>=1;i--) {
            ListNode node = new ListNode(i);
            if(temp != null) {
                node.next = temp;
            }
            temp = node;
        }
        ListNode head = temp;
        while(temp.next != null) {
            System.out.print(temp.val + ",");
            temp = temp.next;
        }
        System.out.println();
        ListNode reverse = reverseBetween(head, 2,12);
        while (reverse.next != null) {
            System.out.print(reverse.val + ",");
            reverse = reverse.next;
        }
    }
}
