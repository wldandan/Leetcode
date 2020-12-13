package com.wl.backtrace;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);
        ListNode curr = head;
        int carry = 0;

        while(l1 != null || l2 !=null){
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;

            curr.next = new ListNode(sum);
            curr = curr.next;

            if (l1.next != null) l1= l1.next;
            if (l2.next != null) l2= l2.next;
        }

        if(carry == 1 ){
            curr.next = new ListNode(carry);
        }

        return head.next;
    }


    /*
    *
    * int sum = l1.val + l2.val;
        int carry = sum / 10;
        sum = sum % 10;

        ListNode head = new ListNode(sum);
        ListNode curr = head;

        while(l1.next!= null || l2.next !=null){
            sum = l1.val + l2.val + carry;
            carry = sum / 10;
            sum = sum % 10;

            curr.next = new ListNode(sum);
            curr = curr.next;
        }

        if(carry > 0 ){
            curr.next = new ListNode(1);
        }

        return head;
    *
    * */

}