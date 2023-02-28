package com.example.leetcode;

public class LetCode141 {

    /**
     * 快慢指针法
     * 两个指针，慢指针、快指针
     * 慢指针
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next.next;

        while (slow != fast) {
            if (fast == null || fast.next.next == null || slow == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
