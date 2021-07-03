package com.leetcode.explore;

import java.util.Arrays;

/*

62. 不同路径

一个机器人位于一个 m x n 网格的左上角
机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角
问总共有多少条不同的路径？

示例 1：
输入：m = 3, n = 7
输出：28

示例 2：
输入：m = 3, n = 2
输出：3
解释：
从左上角开始，总共有 3 条路径可以到达右下角。
1. 向右 -> 向下 -> 向下
2. 向下 -> 向下 -> 向右
3. 向下 -> 向右 -> 向下

示例 3：
输入：m = 7, n = 3
输出：28

示例 4：
输入：m = 3, n = 3
输出：6

提示：
1 <= m, n <= 100
题目数据保证答案小于等于 2 * 10^9

*/

public class Prob0062 {
    // 备忘录
    class Solution1 {
        public int uniquePaths(int m, int n) {
            if (m <= 0 || n <= 0) return 0;
            int[][] memo = new int[m + 1][n + 1];
            return helper(m, n, memo);
        }

        int helper(int m, int n, int[][] memo) {
            if (m == 1 || n == 1) return 1;
            if (memo[m][n] > 0) return memo[m][n];
            return memo[m][n] = helper(m - 1, n, memo) + helper(m, n - 1, memo);
        }
    }

    // 自底而上的动态规划
    class Solution2 {
        public int uniquePaths(int m, int n) {
            if (m <= 0 || n <= 0) return 0;
            int[][] dp = new int[m][n];
            for (int i = 0; i < m; ++i) dp[i][0] = 1;
            for (int j = 0; j < n; ++j) dp[0][j] = 1;
            for (int i = 1; i < m; ++i) {
                for (int j = 1; j < n; ++j) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
            return dp[m - 1][n - 1];
        }
    }

    // 空间优化
    class Solution3 {
        public int uniquePaths(int m, int n) {
            if (m <= 0 || n <= 0) return 0;
            int[] dp = new int[n];
            Arrays.fill(dp, 1);
            for (int i = 1; i < m; ++i) {
                for (int j = 1; j < n; ++j) {
                    dp[j] += dp[j - 1];
                }
            }
            return dp[n - 1];
        }
    }
}
