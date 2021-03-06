package com.leetcode.explore;

/*

最长公共前缀

编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，返回空字符串 ""。

示例 1:
输入: ["flower","flow","flight"]
输出: "fl"

示例 2:
输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。

说明:
所有输入只包含小写字母 a-z 。

*/

public class Prob0014 {
	class Solution {
		public String longestCommonPrefix(String[] strs) {
			if (strs.length == 0) {
				return "";
			}
			String pre = strs[0];
			for (int i = 1; i < strs.length; ++i) {
				int j = 0;
				while (j < pre.length() && j < strs[i].length()) {
					if (pre.charAt(j) != strs[i].charAt(j)) {
						break;
					} else {
						++j;
					}
				}
				pre = pre.substring(0, j);
				if (pre.equals("")) {
					return pre;
				}
			}
			return pre;
		}
	}
}
