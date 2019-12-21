package com.demo.test.leetcode; /**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

 示例:

 输入: [0,1,0,3,12]
 输出: [1,3,12,0,0]
 说明:

 必须在原数组上操作，不能拷贝额外的数组。
 尽量减少操作次数。

 */


/**
 * TODO
 *
 * @author houyujia
 * @since 2019/12/14
 */

public class movezero283 {
    public static void main(String[] args) {
        int[] a=new int[]{2,1,4,3,12};

        System.out.println(method3(a).toString());


    }

    /**
     * 解法一，遇到非0，放前面，并用index记录已放好非零个数，再补齐0
     * 时间复杂度 O（n）
     * @param a
     * @return
     */
    private static int[] method1(int[] a){
        if (a==null){
            return null;
        }
       int  index=0;
        for (int i = 0; i < a.length ; i++) {
            if (a[i]!=0){
                a[index]=a[i];
                index++;
            }

        }
        for (int i = index; i < a.length; i++) {
            a[index]=0;
        }


        return a;
    }
    /**
     * 解法二，遇到非0，放前面，并用index记录已放好非零个数，当遍历次数大于非0index时，设为0
     * 时间复杂度 O（n）
     * @param a
     * @return
     */
    private static int[] method2(int[] a){
        if (a==null){
            return null;
        }
        int  index=0;
        for (int i = 0; i < a.length ; i++) {
            if (a[i]!=0){
                a[index]=a[i];
                if (index<i){
                    a[i]=0;
                }
                index++;
            }
        }


        return a;
    }

    /**
     * 目前个人最优解
     * index记录非0个数，如遇非0，将其交换到index位置，0会自动排后
     ** 时间复杂度 O（n）
     * @param a
     * @return
     */
    private static  int[] method3(int[] a) {
        if (a==null){
            return null;
        }
        //index记录非0个数，如遇非0，将其移动到index位置
        int index=0;
        for (int i = 0; i < a.length; i++) {
            if (a[i]!=0){
                System.out.println("i:"+i+" index:"+index);
                swap(a,index++,i);

            }
        }
        return  a;
    }

    public static void swap(int[] array,int x,int y){
        int xx = array[x];
        int yy = array[y];
        array[x] = yy;
        array[y] = xx;
    }

}



