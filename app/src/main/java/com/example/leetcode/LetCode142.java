package com.example.leetcode;

import com.example.common.ListNode;

public class LetCode142 {

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = null;
        ListNode fast = null;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }

            // 成环
            if (slow == fast) {
                ListNode ptr = head;
                // a = c + (n-1)(b+c)
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }
}
