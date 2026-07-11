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
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        ListNode tail = null;
        ListNode newnode = null;
        while(curr != null){
            ListNode temp = curr;
            int count = 0;
            while(temp!=null){
                temp = temp.next;
                count++;
            }
            if(count<k){
                if(tail != null) tail.next = curr;
                break;
            }
            ListNode knopair = curr;
            ListNode prev = null;
            ListNode next = null;
            count = 0;
            while(curr != null && count<k ){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                count++;
            }
            if(newnode == null) newnode = prev;
            if(tail != null) tail.next = prev;
            tail = knopair;
        }
        return newnode;
    }
    public static void printList(ListNode cur){
        while(cur != null){
            System.out.print(cur.val);
            if(cur != null){
                System.out.print("->");
            }
            cur = cur.next;
        }
        System.out.println();
    }
}