package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LetCode46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        // 辅助数组
        int[] visited = new int[nums.length];
        backtrack(result, nums, path, visited);
        return result;
    }

    public void backtrack(List<List<Integer>> result, int[] nums, List<Integer> path, int[] visited) {

        // if 满足结束条件
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        // for 选择 in 选择列表
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) {
                continue;
            }
            // 做选择
            visited[i] = 1;
            path.add(nums[i]);
            backtrack(result, nums, path, visited);
            // 撤销选择
            visited[i] = 0;
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new LetCode46().permute(nums));
    }
}
