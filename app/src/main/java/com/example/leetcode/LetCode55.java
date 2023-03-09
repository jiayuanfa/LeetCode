package com.example.leetcode;

public class LetCode55 {

    public boolean canJump(int[] nums) {
        // 最远的位置
        int right = 0;
        for (int i = 0; i < nums.length; i++) {
            // 初始化
            if (i == 0) {
                right = nums[0];

                // 此处添加条件是为了防止角标走到了末尾的情况
            } else if (i <= right) {
                right = Math.max(right, i + nums[i]);
            }

            // 条件成立，注意边界值
            if (right >= (nums.length - 1)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 0, 4};
//        int[] nums = {0};
//        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(new LetCode55().canJump(nums));
    }
}
