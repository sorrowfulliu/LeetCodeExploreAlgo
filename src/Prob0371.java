package com.leetcode.explore;

/*

371. 两整数之和

不使用运算符 + 和 - ，计算两整数 a 、b 之和。

示例 1:
输入: a = 1, b = 2
输出: 3

示例 2:
输入: a = -2, b = 3
输出: 1

*/

public class Prob0371 {
    class Solution {
        public int getSum(int a, int b) {
            while (b != 0) {
                int c = (a & b) << 1;
                a ^= b;
                b = c;
            }
            return a;
        }
    }
}
