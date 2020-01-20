
class Solution {
    public boolean isValidSudoku(char[][] board) {
        //  init data
        HashMap<Integer, Integer>[] rows = new HashMap[9];
        HashMap<Integer, Integer>[] cols = new HashMap[9];
        HashMap<Integer, Integer>[] boxes = new HashMap[9];
        for (int i = 0; i < 9; ++i) {
            rows[i] = new HashMap<Integer, Integer>();
            cols[i] = new HashMap<Integer, Integer>();
            boxes[i] = new HashMap<Integer, Integer>();
        }
        //  validate a board
        for (int i = 0; i < 9; ++i)
            for (int j = 0; j < 9; ++j) {
                char num = board[i][j];
                if (num != '.') {
                    int n = (int)num;
                    int boxIndex = (i / 3) * 3 + j / 3;
                    System.out.println("i" + i + "j" + j + " " + boxIndex);
                    //  keep the current cell value
                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                    cols[j].put(n, cols[j].getOrDefault(n, 0) + 1);
                    boxes[boxIndex].put(n, boxes[boxIndex].getOrDefault(n, 0) + 1);
                    
                    //  check if this value has been already seen before
                    if (rows[i].get(n) > 1 || cols[j].get(n) > 1 || boxes[boxIndex].get(n) > 1)
                        return false;
                }
            }
        return true;
    }
}
