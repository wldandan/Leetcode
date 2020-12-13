package com.wl.linkedlist;

import com.wl.backtrace.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution24 {

    public ListNode reverseList(ListNode head) {

        ListNode next = head.next;
        ListNode curr = reverseList(next);
        next.next = head;
        head.next = null;
        return curr;

    }


    public ListNode reverseList2(ListNode head) {

        ListNode pre = null;
        ListNode curr = head;
        ListNode next = head.next;

        while(next != null){
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return curr;
    }
}