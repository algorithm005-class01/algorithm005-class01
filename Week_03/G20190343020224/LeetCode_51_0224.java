//回溯
class Solution {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> output = new ArrayList<>();
        trackback(n, output, new ArrayList<>());
        return output;
    }

    public void trackback(int n, List<List<String>> output, List<String> comb) {
        if (comb.size() == n) {
            output.add(new ArrayList<>(comb));
            return;
        }
        for (int i = 0; i < n; i++) {
            //行
            String line = "";
            for (int j = 0; j < n; j++) {
                String col = j == i ? "Q" : ".";
                line += col;
            }
            //
            comb.add(line);
            if (isValid(comb)) {
                trackback(n, output, comb);
            }
            comb.remove(comb.size() - 1);
        }
    }

    public boolean isValid(List<String> comb) {
        if (comb.size() <= 1) {
            return true;
        }
        String latest = comb.get(comb.size() - 1);
        for (int i = 0; i < comb.size() - 1; i++) {
            int index = latest.indexOf("Q");
            String cur = comb.get(i);
            int curIndex = cur.indexOf("Q");
            if (index == curIndex) {
                return false;
            }
            if (Math.abs(curIndex - index) == comb.size() - i - 1) {
                return false;
            }
        }
        return true;
    }

}