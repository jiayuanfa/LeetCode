package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LetCode92 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 定义一个dummyHead, 方便处理
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        // 初始化指针
        ListNode g = dummyHead;
        ListNode p = dummyHead.next;

        // 将指针g p移到相应的位置
        for(int step = 0; step < left - 1; step++) {
//            System.out.println("step=" + step);
            g = g.next; p = p.next;
//            System.out.println("g=" + g.val);
//            System.out.println("p=" + p.val);
        }

        // 头插法插入节点
        /**
         * 每次操作p节点后面的节点，也就是需要移动的节点，我们称之为removed
         * 先拿出来改节点
         * 然后把p节点的next指向后面的后面节点
         * 然后把remove节点的next指向到g的next，即实现了前挪
         * 最后再把g的next指向removed即可
         */
        for (int i = 0; i < right - left; i++) {
            ListNode removed = p.next;

//            System.out.println("第" + i + "次操作" + "g=" + g.val);
//            System.out.println("第" + i + "次操作" + "p=" + p.val);
//            System.out.println("第" + i + "次操作" + "removed=" + removed.val);

            p.next = p.next.next;
            removed.next = g.next;
            g.next = removed;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        nums.add(5);
        ListNode head = ListNode.buildList(nums);
        head = new LetCode92().reverseBetween(head, 2, 4);
        ListNode.travelList(head);
    }
}

