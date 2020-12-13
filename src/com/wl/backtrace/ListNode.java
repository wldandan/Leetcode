package com.wl.backtrace;

import java.util.ArrayList;
import java.util.List;

public class ListNode {
     public int val;
     public ListNode next;
     public ListNode(int x) { val = x; }

     public List<Integer> print(){
          List<Integer> res = new ArrayList<>();
          res.add(val);
          while(next !=null){
               res.add(next.val);
               next = next.next;
          }
          return res;
     }
}
 