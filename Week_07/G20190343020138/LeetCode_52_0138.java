package com.log8.week07;

/*
https://leetcode-cn.com/problems/n-queens-ii/description/
 */
public class Solution52 {
    //
    int ret;
    int size;
    public int totalNQueens(int n) {
        if(n<=0) return 0;
        ret = 0;
        size = (1<<n)-1;
        solves(n,0,0,0,0);
        return ret;
    }

    //
    public void solves(int n,int row,int col,int pie, int na){
        if(row==n){
            ret = ret + 1;
            return ;
        }

        int bits = (~(col|pie|na))&size;

        while(bits!=0){
            //获取低位的1 即需要移动的位置
            int p = bits & -bits;
            //移除bits 最后一位1 即消除最后一个1
            bits = bits & (bits-1);

            solves(n,row+1,(col|p),(pie|p)<<1,(na|p)>>1);
        }

    }

    public static void main(String[] args) {
        Solution52 s52 = new Solution52();
        System.out.println(s52.totalNQueens(4));
    }
}
