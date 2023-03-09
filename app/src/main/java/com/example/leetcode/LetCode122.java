package com.example.leetcode;

public class LetCode122 {

    public int maxProfit(int[] prices) {
        int result = 0;

        // 保存第i天持有/不持有股票的最大利润
        int[][] dp = new int[prices.length][2];

        // 第一天不持有股票的利润
        dp[0][0] = 0;

        // 第一天持有股票的利润
        dp[0][1] = -prices[0];

        // for循环计算从第一天到最后一天之间并存入二维数组
        // 第i天不持有股票的利润
        // 第i天持有股票的利润
        for (int i = 1; i < prices.length; i++) {

            // 计算当天持有/不持有股票的利润，只要和前一天的值进行对比，拿到最大值即可
            // 如果当天没持有，则计算第二天持有的利润
            // 如果当天持有，则计算第二天卖掉的利润
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }

        // 比较最后一天持有/不持有股票利润的最大值即可
        result = Math.max(dp[prices.length - 1][0], dp[prices.length - 1][1]);

        return result;
    }
}
