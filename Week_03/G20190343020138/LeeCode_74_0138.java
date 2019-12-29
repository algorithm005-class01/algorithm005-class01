package com.log8.week03;

//https://leetcode-cn.com/problems/search-a-2d-matrix/
// most vote
//https://leetcode.com/problems/search-a-2d-matrix/discuss/26220/Don't-treat-it-as-a-2D-matrix-just-treat-it-as-a-sorted-list
public class Solution74 {

    public boolean searchMatrix(int[][] matrix,int target){
        if(matrix==null){
            return false;
        }
        int low = 0;
        int m = matrix.length ;
        int n = matrix[0].length;
        int hight = n*m - 1;
        int midn;
        int midm;
        //关于此处while条件判断 必须加上等号判断
        while(low<=hight){
            midn = ((low+hight)/2)%n;
            midm = ((low+hight)/2)/n;
            if(matrix[midm][midn]<target){
                low = ((low+hight)/2)+1;
            }else if(matrix[midm][midn]==target){
                return true;
            }else{
                hight = ((low+hight)/2)-1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,   3,  5,  7},
                {10, 11, 16, 20},
         {23, 30, 34, 50}
        };
        Solution74 s74 = new Solution74();
        System.out.println(s74.searchMatrix(matrix, 3));
        System.out.println(s74.searchMatrix(matrix, 13));
    }
}
