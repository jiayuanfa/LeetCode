package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LetCode54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        // 右、下、左、上
        int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        /**
         * rows 总行数
         * cols 总列数
         * row 开始行
         * col 开始列
         * currDirection 当前的方向默认是0
         */
        int rows = matrix.length;
        int cols = matrix[0].length;
        int row = 0;
        int col = 0;
        int currDirection = 0;

        /**
         * 记录被访问的节点
         */
        boolean[][] visited = new boolean[rows][cols];

        /**
         * 遍历
         * 确保每一个数据都被处理到 rows * cols
         */
        for (int i = 0; i < rows * cols; i++) {

            // 每次遍历一个数据 添加到result数组
            result.add(matrix[row][col]);
            System.out.println("添加了" + matrix[row][col]);

            // 把该数据置为已访问
            visited[row][col] = true;

            /**
             * 通过当前的方向去确定下一个数据的行列
             * 从方向的二元数组种拿出该方向的值，比如当前方向是0，拿出的就是右也就是{0, 1}
             * 也就是行数不变，列数+1
             */
            int nextRow = row + directions[currDirection][0];
            int nextCol = col + directions[currDirection][1];

            System.out.println("nextRow=" + (row + directions[currDirection][0]));
            System.out.println("nextCol=" + (col + directions[currDirection][1]));

            /**
             * 转弯
             * 边界值处理
             * 小于左右边界值或者已访问过，则顺时针拐弯
             */
            if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols || visited[nextRow][nextCol]) {
                currDirection = (currDirection + 1) % 4;
            }

            row += directions[currDirection][0];
            col += directions[currDirection][1];
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        int[][] matrix1 = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
        System.out.println(new LetCode54().spiralOrder(matrix));
    }
}
