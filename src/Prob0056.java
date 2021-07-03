package com.leetcode.explore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*

56. 合并区间

以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [start_i, end_i]
请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间

示例 1：
输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
输出：[[1,6],[8,10],[15,18]]
解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].

示例 2：
输入：intervals = [[1,4],[4,5]]
输出：[[1,5]]
解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。

提示：
1 <= intervals.length <= 10^4
intervals[i].length == 2
0 <= start_i <= end_i <= 10^4

*/

public class Prob0056 {
    class Solution {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });
            List<int[]> res = new ArrayList<>();
            res.add(intervals[0].clone());
            for (int[] interval : intervals) {
                int[] tmp = res.get(res.size() - 1);
                if (interval[0] <= tmp[1]) {
                    tmp[1] = Math.max(interval[1], res.get(res.size() - 1)[1]);
                } else {
                    res.add(interval.clone());
                }
            }
            return res.toArray(new int[res.size()][]);
        }
    }
}
