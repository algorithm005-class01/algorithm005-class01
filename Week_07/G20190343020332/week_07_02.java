class Solution {
    private int size;
    private int count;
    public int totalNQueens(int n) {
        count = 0;
        size = (1 << n) - 1;
        _totalNQueens(0, 0 , 0);
        return count;
    }

    public void _totalNQueens(int row, int ld, int rd){
        if(row == size){
            count++;
            return;
        }
        int pos = size & ~(row | ld | rd);
        while(pos != 0){
            int p = pos & -pos;
            pos &= (pos - 1);
            _totalNQueens(row | p, (ld | p) << 1, (rd | p) >> 1);
        }
    }
}