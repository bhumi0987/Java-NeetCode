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
    public ListNode reverse(ListNode head){
        ListNode prev=head;
        ListNode curr=head.next;
        while(curr!=null){
            ListNode future=curr.next;
            curr.next=prev;
            prev=curr;
            curr=future;
        }
        head.next=null;
        head=prev;
        return head;
    }
    public int pairSum(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(slow.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode nhead=slow.next;
        slow.next=null;
        nhead=reverse(nhead);
        int max=0;
        while(head!=null&&nhead!=null){
            max=Math.max(max,head.val+nhead.val);
            head=head.next;
            nhead=nhead.next;
        }
        return max;
    }
}