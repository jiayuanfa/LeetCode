package com.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetCode15 {

    public List<List<Integer>> threeSum(int[] nums) {

        // 从小到大排序
        Arrays.sort(nums);

        int length = nums.length;
        List<List<Integer>> results = new ArrayList<>();

        for (int i = 0; i < length; i++) {

            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 拿到最右边的位置
            int R = length - 1;

            // 枚举b
            for (int L = i + 1; L < length; L ++) {
                // 去重
                if (L > i + 1 && nums[L] == nums[L - 1]) {
                    continue;
                }

                // 枚举c
                // 首先L小于R，然后 i L R 三者之和大于0 说明R不满足需求，需要左移
                while (L < R && nums[L] + nums[R] + nums[i] > 0) {
                    R -= 1;
                }
                // L等于R，说明已经到了边界break
                if (L == R) {
                    break;
                }

                // 最后 把三者之和等于0的加入result数组即可
                if (nums[L] + nums[R] + nums[i] == 0) {
                    List<Integer> result = new ArrayList<>();
                    result.add(nums[L]);
                    result.add(nums[R]);
                    result.add(nums[i]);
                    results.add(result);
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(new LetCode15().threeSum(nums));
    }
}
