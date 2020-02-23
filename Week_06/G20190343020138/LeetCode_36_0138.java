class Solution {
    //按照光头哥思路 重新写一遍
    //https://leetcode.com/problems/valid-sudoku/discuss/15472/Short%2BSimple-Java-using-Strings
    // 4 in rows(7)   表示为  (4)7
    // 4 in column(7) 表示为  7(4)
    // 4 in block 2   表示为  0(4)2
    public boolean isValidSudoku(char[][] board) {
        Set set = new HashSet<String>();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char val = board[i][j];
                if(val=='.') con从tinue;
                String b = "("+val+")";
                if(!set.add(b+i)  //判断行是否合法
                   ||!set.add(j+b) //判断列是否合法
                   ||!set.add(i/3+b+j/3))  //判断块是否合法
                   return false;
            }
        }
        return true;
    }
}
