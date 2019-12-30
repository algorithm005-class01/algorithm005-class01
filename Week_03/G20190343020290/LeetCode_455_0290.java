package com.jtel.ekoo;

import java.util.*;

/**
 * Created by Ju·Felix on 2019/12/29.
 */
public class LeetCode_455_0290 {
    public static void main(String[] args) {
        int[] childen = {1, 2, 3};
        int[] cookies = {1, 1};
        int manzu = findContentChildren(childen, cookies);
        System.out.println(manzu);
    }

    private static int findContentChildren(int[] grid, int[] size) {
        if (grid == null || size == null) return 0;
        Arrays.sort(grid);
        Arrays.sort(size);
        int gi = 0, si = 0;
        while (gi < grid.length && si < size.length) {
            if (grid[gi] <= size[si]) {
                gi++;
            }
            si++;
        }
        return gi;
    }
}
