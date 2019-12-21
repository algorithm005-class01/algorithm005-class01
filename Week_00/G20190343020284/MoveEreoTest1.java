package test;

import java.util.Arrays;

public class MoveEreoTest1 {
    public static void main(String[] args) {
        int data[] = {0, 1, 0, 3, 12};
        int j = 0;
        for (int i = 0; i < data.length; i++) {

            if (data[i] == 0) {

                if(i!=j){
                    data[j]=data[i];
                    data[i]=0;
                }

                j++;
            }




        }
        System.out.println(Arrays.toString(data));
    }

    public static void main1(String[] args) {
        int data[] = {0, 1, 0, 3, 12};
        int data1[] = new int[data.length];
        int j = 0;
        int k = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] != 0) {
                data1[j] = data[i];
                j++;
            } else {
                data1[data.length - k - 1] = data[i];
                k++;
            }
        }
        System.out.println(Arrays.toString(data1));
    }

}