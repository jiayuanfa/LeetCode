package com.example.leetcode;

import java.util.List;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {

    }
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val; this.next = next;
    }

    /**
     * 构建链表
     * @param nums
     * @return
     */
    public static ListNode buildList(List<Integer> nums) {
        if (nums == null || nums.size() == 0) {
            return null;
        }
        ListNode head = new ListNode(nums.get(0), null);
        ListNode curr = head;
        for(int i = 1; i < nums.size(); i ++) {
            curr.next = new ListNode(nums.get(i), null);
            curr = curr.next;
        }
        return head;
    }

    /**
     * 打印链表
     * @param head
     */
    public static void travelList(ListNode head) {
        ListNode curr = head;
        while(curr != null) {
            System.out.printf("%d->", curr.val);
            curr = curr.next;
        }
        System.out.println();
    }
}
