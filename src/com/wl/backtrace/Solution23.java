package com.wl.backtrace;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution23 {

    List<Integer> list = new ArrayList<>();

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode current = head;

        int count = lists.length;
        int sum = 0;


        for (int i = 0; i < count; i++) {
            sum = sum + getListNodeLength(lists[i]);
        }

        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            current.next = new ListNode(list.get(i));
            current = current.next;
        }
        return head.next;
    }

    private int getListNodeLength(ListNode node){
        int length = 0;
        while(node!=null){
            list.add(node.val);
            node = node.next;
            length++;
        }
        return length;
    }
}