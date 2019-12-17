package test;

import java.util.Arrays;

public class MoveEreoTest {
    public static void main1(String[] args) {
        int data[] = null;
        data = new int[3];
        data[0] = 10;
        data[1] = 20;
        data[2] = 30;
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }

    }

    public static void main(String[] args) {
        int data[] = {1, 3, 5, 0, 8, 0, 9};
        moveZeroes(data);
        System.out.println(Arrays.toString(data));
    }

    public static void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if (i != j) {
                    nums[i] = 0;
                }
                j++;
            }
        }
    }
}
