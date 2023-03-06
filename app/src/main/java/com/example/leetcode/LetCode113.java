package com.example.leetcode;

import com.example.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LetCode113 {

    public List<List<Integer>> pathSum(TreeNode root, int targetNum) {
        List<List<Integer>> result = new ArrayList<>();
        preOrder(root, result, new ArrayList<>(), targetNum);
        return result;
    }

    public void preOrder(TreeNode head, List<List<Integer>> result, List<Integer> path, int targetNum) {
        if (head == null) {
            return;
        }
        path.add(head.val);
        targetNum -= head.val;
        if (head.leftNode == null && head.rightNode == null && targetNum == 0) {
            result.add(new ArrayList<>(path));
        }

        // 继续递归查询
        preOrder(head.leftNode, result, new ArrayList<>(path), targetNum);
        preOrder(head.rightNode, result, new ArrayList<>(path), targetNum);
    }

}
