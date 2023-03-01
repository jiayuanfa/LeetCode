package com.example.leetcode;

import java.util.Vector;

/**
 * 使用双栈实现队列
 * 剑指Offer09
 */
public class LetCodeOffer09 {

    private Vector<Integer> vec1;
    private Vector<Integer> vec2;

    public LetCodeOffer09() {
        vec1 = new Vector<>();
        vec2 = new Vector<>();
    }

    public void appendTail(int value) {
        this.vec1.add(value);
    }

    public int deleteHead() {
        if (vec1.size() == 0 && vec2.size() == 0) {
            return -1;
        }

        if (vec2.size() == 0) {
            while (!vec1.isEmpty()) {
                vec2.add(vec1.remove(vec1.size() - 1));
            }
        }
        return vec2.remove(vec2.size() - 1);
    }
}
