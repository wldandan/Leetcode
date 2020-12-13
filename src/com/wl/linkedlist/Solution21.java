package com.wl.linkedlist;

import com.wl.backtrace.ListNode;

class Solution21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode res = null;
        ListNode head = null;
        int val = 0;

        if (l1 == null && l2 == null) return null;

        while(l1 !=null || l2 !=null){

            int l1value = Integer.MAX_VALUE;
            int l2value = Integer.MAX_VALUE;

            if (l1 != null) {
                l1value = l1.val;
            }
            if (l2 != null) {
                l2value = l2.val;
            }

            if (l2value <= l1value){
                val = l2value;
                l2 = l2.next;
            } else if (l1value < l2value){
                val = l1value;
                l1 = l1.next;
            }
            if (res == null) {
                res = new ListNode(val);
                head = res;
            }
            else {
                res.next = new ListNode(val);
                res = res.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);

        Solution21 s = new Solution21();
        ListNode result = s.mergeTwoLists(node1, node2);
        System.out.println(result.print());

        result = s.mergeTwoLists(node1, null);
        System.out.println(result.print());

        result = s.mergeTwoLists(node2, null);
        System.out.println(result.print());

        result = s.mergeTwoLists(null, null);
        if (result == null) System.out.println(false);
    }
}