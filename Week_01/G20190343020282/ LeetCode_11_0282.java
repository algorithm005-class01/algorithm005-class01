package com.demo.test.leetcode;

/**
 * TODO
 *给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

 说明：你不能倾斜容器，且 n 的值至少为 2。


 示例:

 输入: [1,8,6,2,5,4,8,3,7]
 输出: 49

 * @author houyujia
 * @since 2019/12/15
 */

public class containerWithMostWater11 {
    public static void main(String[] args) {
        int[] a=new int[]{1,8,6,2,5,4,8,3,7};
        method3(a);
    }

    /**
     * 解法一，暴力遍历，计算所有可能组合面积，得到最大值
     * 时间复杂度 O（n^2）
     * @param a
     */
    private static void method1(int[] a) {
        if (a==null){
            return;
        }
        int area = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                area = Math.max(area, Math.abs(i - j) * Math.min(a[i], a[j]));
            }
        }
        System.out.println(area);

    }
    /**
     * 解法二，暴力遍历，计算所有可能组合面积（i和j不重复），得到最大值
     * 时间复杂度 O（n^2）
     * @param a
     */
    private static void method2(int[] a){
        if (a==null){
            return;
        }
        int area = 0;
        //i和j不会重复的遍历方式
        for (int i = 0; i < a.length-1; i++) {
            for (int j = i+1; j < a.length; j++) {
                area = Math.max(area, Math.abs(i - j) * Math.min(a[i], a[j]));
            }
        }
        System.out.println(area);
    }

    /**
     * 解法三，双指针在两头向内移动，高度较小的一个向内移动，保证宽度递减，不遗漏
     * 时间复杂度 O（n^2）
     * @param a
     */
    private static void method3(int[] a) {
        if (a==null){
            return;
        }
        int area=0;
        //双指针
        for (int i = 0, j =a.length-1 ; i<j;) {
            int height=a[i]<a[j]?a[i++]:a[j--];
            area=Math.max(area,height*(j-i+1));
        }
        System.out.println(area);
    }











}
