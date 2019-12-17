package org.azai.train.Week01;

public class Leetcode_66_0132 {
    //数组进行倒叙遍历，如果当前值不等于9，说明不会进位，则加上1直接返回，如果当前值等于9，则说明应该进位，往前遍历
    //一直到整个数组遍历完，如果有数组元素都是9的情况，则需要开一直新的数组，数组长度比原来的长度大1，再将首元素置1
    public int[] plusOne(int[] digits) {
        for (int i = digits.length-1;i>=0;i--) {
            digits[i] = (digits[i] + 1)%10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length+1];
        digits[0] = 1;
        return digits;
    }
}
