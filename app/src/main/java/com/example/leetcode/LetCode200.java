package com.example.leetcode;

public class LetCode200 {

    public int numIsLands(char[][] grid) {

        int result = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        // 辅助数组 用来标记每一个数据是否已经被访问过
        int[][] visited = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                visited[i][j] = 0;
            }
        }

        // 如果数据没有被访问过，且数据为1，说明是岛屿，继续向其上下左右搜索，直到上下左右都被访问过且不存在岛屿为止，那么路径就存在一条了，结果+1
        for (int  i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1' && visited[i][j] == 0) {
                    dfs(grid, i, j, visited);
                    result += 1;
                }
            }
        }
        return result;
    }

    /**
     * 深度搜索算法
     * @param grid
     * @param i
     * @param j
     * @param visited
     */
    public void dfs(char[][] grid, int i, int j, int[][] visited) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0' || visited[i][j] == 1) {
            return;
        }
        visited[i][j] = 1;
        // 上
        dfs(grid, i-1, j, visited);
        // 下
        dfs(grid, i+1, j, visited);
        // 左
        dfs(grid, i-1, j-1, visited);
        // 右
        dfs(grid, i-1, j+1, visited);

    }
}
