package com.exercise.week_one.home;/** * @ClassName: * @Description: * @Author: * @Date: *//** *@ClassName LeetCode_01_0340两数之和 *@Description *@Autor *@Date 2019/12/1521:27 *@Version 1.0 *@Example **/public class LeetCode_42_0340接雨水 {    public static void main(String[] args) {        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));    }    // 作业写晚了，只理解了一套暴力解法。。。    public static int trap(int[] height) {        int maxCapacity = 0;        //找到最高值，然后进行循环比对。。。        int maxHigh = 0;        for (int i = 0; i < height.length; i++) {            maxHigh = Math.max(maxHigh,height[i]);        }        // 找到最大值，就是最外层for循环边界        for (int i = 1; i <= maxHigh; i++) {            boolean isStart = false; //标记是否开始更新 temp            int tempMaxCapacity = 0;            for (int j = 0; j < height.length; j++) {                if (isStart && height[j] < i) {                    tempMaxCapacity++;                }                if (height[j] >= i) {                    maxCapacity = maxCapacity + tempMaxCapacity;                    tempMaxCapacity = 0;                    isStart = true;                }            }        }        return maxCapacity;    }}