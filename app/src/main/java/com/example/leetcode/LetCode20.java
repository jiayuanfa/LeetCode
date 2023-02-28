package com.example.leetcode;

import java.util.Vector;

public class LetCode20 {

    /**
     * 利用Vector进行入栈出栈
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Vector<Character> vector = new Vector<>();
        for (int i = 0; i < s.length(); i ++) {
            char ch = s.charAt(i);
            if (vector.size() == 0 || ch == '(' || ch == '[' || ch == '{') {
                vector.add(ch);
                continue;
            }
            if (ch == ')') {
                if (vector.lastElement() == '(') {
                    vector.remove(vector.size() - 1);
                } else {
                    vector.add(ch);
                }
            } else if (ch == ']') {
                if (vector.lastElement() == '[') {
                    vector.remove(vector.size() - 1);
                } else {
                    vector.add(ch);
                }
            } else if (ch == '}') {
                if (vector.lastElement() == '{') {
                    vector.remove(vector.size() - 1);
                } else {
                    vector.add(ch);
                }
            }
        }
        return vector.size() == 0;
    }

    public static void main(String[] args) {
        String s = "[({})()]";
        System.out.println(new LetCode20().isValid(s));
    }
}
