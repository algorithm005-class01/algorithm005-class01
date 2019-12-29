/*
LeetCode 51, N皇后问题
思路: 通过回溯法求解
逐行求解, 每一行是一个层次,
在每一列尝试放置皇后, 判断是否冲突(冲突为同列有皇后，对角线上有皇后)
对角线的处理技巧: 主对角线的行-列值是一样的, 次对角线的行+列值是一样的

如果成功放置需要更新一下几个Set和当前棋盘状态
放好以后drilldown到下个层次, 
回溯时需要重置状态, 除了清理当前棋盘状态外, 还需清理Set中保存的值
*/
class Position {
    int row;
    int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public List<List<String>> solveNQueens(int n) {
        Set<Integer> sameCol = new HashSet<>(); //同列, 保存col值
        Set<Integer> mainCross = new HashSet<>(); //主对角线, 左上->右下, 保存row-col值
        Set<Integer> secondCross = new HashSet<>(); //次对角线, 右上->左下, 保存row+col值

        List<List<String>> answer = new ArrayList<>();
        List<Position> currentAnswer = new ArrayList<>();

        int row = 0;
        solve(answer, currentAnswer, row, n, sameCol, mainCross, secondCross);

        return answer;
    }

    private void solve(List<List<String>> answer, List<Position> currentAnswer, int row, int n,
                       Set<Integer> sameCol, Set<Integer> mainCross, Set<Integer> secondCross) {
        if (row == n) {
            answer.add(transToString(currentAnswer, n));
            return;
        }

        for (int i = 0; i < n; i++) {
            //Try place a queen in position(row, i)
            if (sameCol.contains(i) || mainCross.contains(row - i) || secondCross.contains(row + i)) {
                //Bad Position.
                continue;
            }
            //Good Position.
            sameCol.add(i);
            mainCross.add(row - i);
            secondCross.add(row + i);
            currentAnswer.add(new Position(row, i));

            //To Next Level
            solve(answer, currentAnswer, row + 1, n, sameCol, mainCross, secondCross);
            //Clear State
            currentAnswer.remove(currentAnswer.size() - 1);
            sameCol.remove(i);
            mainCross.remove(row - i);
            secondCross.remove(row + i);
        }
    }

    private List<String> transToString(List<Position> currentAnswer, int n) {
        List<String> chessDesk = new ArrayList<>();
        for (Position p: currentAnswer) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (i == p.col) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            chessDesk.add(sb.toString());
        }
        return chessDesk;
    }
}