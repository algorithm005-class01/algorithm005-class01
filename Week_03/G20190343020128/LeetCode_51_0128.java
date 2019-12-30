import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N皇后
 */

// @lc code=start
class Solution {
     //竖排被占登记，用于判断是否能够被竖排攻击
     int rows[]; //
     // "从左到右对角线" 登记，用于判断是否能够被竖排攻击
     int hills[];
     // "从右到左对角线" 登记，用于判断是否能够被竖排攻击
     int dales[];
     int n;
     // output
     List<List<String>> output = new ArrayList<>();
     // 皇后的位置
     int queens[];
 
     /**
      * 判断该位置是否会被攻击
      * @param row
      * @param col
      * @return
      */
     public boolean isNotUnderAttack(int row, int col) {
         int res = rows[col] + hills[row - col +  n - 1] + dales[row + col];
         return (res == 0) ? true : false;
     }
 
     /**
      * 将皇后放入该位置
      * @param row
      * @param col
      */
     public void placeQueen(int row, int col) {
         queens[row] = col;   //将皇后位置放入
         rows[col] = 1;   //竖排攻击位置
         hills[row - col +  n - 1] = 1;  // "从左到右对角线" 攻击位置
         dales[row + col] = 1;   //"从右到左对角线" 攻击位置
     }
 
     /**
      * 回溯皇后位置
      * @param row
      * @param col
      */
     public void removeQueen(int row, int col) {
         queens[row] = 0;
         rows[col] = 0;
         hills[row - col + n - 1] = 0;
         dales[row + col] = 0;
     }
 
     /**
      * 将满足条件的皇后位置放入output中
      */
     public void addSolution() {
         List<String> solution = new ArrayList<String>();
         for (int i = 0; i < n; ++i) {
             int col = queens[i];
             StringBuilder sb = new StringBuilder();
             for(int j = 0; j < col; ++j) sb.append(".");
             sb.append("Q");
             for(int j = 0; j < n - col - 1; ++j) sb.append(".");
             solution.add(sb.toString());
         }
         output.add(solution);
     }
 
     public void backtrack(int row) {
         for (int col = 0; col < n; col++) {
             if (isNotUnderAttack(row, col)) {
                 placeQueen(row, col);
                 // 皇后数量是否满足，满足则输出
                 if (row + 1 == n) addSolution();
                 // 不满足则继续
                 else backtrack(row + 1);
                 // 回溯。
                 removeQueen(row, col);
             }
         }
     }

    /**
     * 方法一：回溯法
     *      首先需要申请4个int数组，
     *          rows代表着被攻击的列，比如说将第一个皇后放到第0列中，rows[0]=1,代表着第0列不可再放置其他皇后了，如果
     *          第二个皇后放置到了第2列中，则rows[2]=1，那么剩下的皇后只能放置在0~n列当中值为0的列了
     *          hill代表着捺方向的攻击路线，由于这条线上row减col为一个定值，所以也用数组表示，但是由于结果可能出现负
     *          数，所以将数组的大小扩容一倍，每次减完，需要再加(n-1)个位置，以确保数组下标不会越界。
     *          dales代表着撇方向的攻击路线，由于这条线上row加col为一个定值，所以也用数组表示，由于加起来的值可能越界
     *          所以也用2倍大小。
     *          queens数组代表着存储已经放好皇后集合，下标代表着行，而其中的值代表着列
     *          hill和rows这两个数组设计的非常巧妙，一条线上的所有攻击点都可以用一个值进行判断，节省很多时空。
     *      其次进行递归，传入当前所在行。用迭代挨个判断列是否可行。首先需要判断是否在之前皇后的攻击范围内，即行和列
     *      不能在rows，dales和hill这三个数组中。
     *      如果不在，那么这个点就可以放置皇后了。并且需要更新rows，hill和dales这三个数组，queens数组也需要更新，
     *      这是需要先判断一下（结束条件在此）是否已经到了最后一行了，如果到了则说明找到结果了，没有则继续row+1递归
     *      这层递归的最后，还需要做一件事情，我们先想想什么情况会走到这里，其实有两种，一种是已经找到结果了，另一种
     *      是下层所有的格子都不能放置。这时无论哪种，我们都需要清理此处放置的皇后，即在queens数组总清理和清理他的
     *      攻击路线，并进入下一次列的循环中。
     *      整个迭代走完以后，我们需要打印结果。结果已经打印好了，就在之前找到结果的时候就已经打印好并放到结果集中了
     *      打印按照层来遍历，首先在该曾拿到皇后的列号，即col = queens[i];小标为col，实际是第col+1个数，所以先打印
     *      col个. 然后打印一个特殊Q，一共n个数，已经打印了col+1个数，剩下再打印n-col-1个点即可
     * 复杂度分析：
     *      时间：O(n!) 
     *      空间：O(n)
     * 
     * @param n
     * @return
     */
    public List<List<String>> traceBackMethod(int n){
        this.n = n;
        rows = new int[n];
        hills = new int[2 * n - 1];
        dales = new int[2 * n - 1];
        queens = new int[n];

        backtrack(0);
        return output;
    }

    public List<List<String>> solveNQueens(int n) {
        return traceBackMethod(n);
    }
}
// @lc code=end

