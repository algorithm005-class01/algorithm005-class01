class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[] cs = new char[n];
        Arrays.fill(cs, '.');
        return backtrack(cs, 0, n, new int[n], new int[2 * n], new int[2 * n], new LinkedList<String>(), new ArrayList<List<String>>());    
    }

    private List<List<String>> backtrack(char[] cs, int row, int n, int[] cols, int[] maindiagonals, int[] subdiagonals, LinkedList<String> list, List<List<String>> res) {
        if (row == n) {
            res.add(new ArrayList<String>(list));
        } else {
            for (int col = 0; col < n; col++) {
                if (cols[col] == 1 || maindiagonals[row + col] == 1 || subdiagonals[row - col + n] == 1) continue;
                cols[col] = 1;
                maindiagonals[row + col] = 1;
                subdiagonals[row - col + n] = 1;

                cs[col] = 'Q';
                list.add(String.valueOf(cs));
                cs[col] = '.';
                backtrack(cs, row + 1, n, cols, maindiagonals, subdiagonals, list, res);
                list.removeLast();

                cols[col] = 0;
                maindiagonals[row + col] = 0;
                subdiagonals[row - col + n] = 0;
            }
        }
        return res;
    }
}