import java.util.LinkedList;
import java.util.List;

public class LeetCode_22_0190 {
    public List<String> generateParenthesis(int n) {
        List<String> list = new LinkedList<>();
        this.backTrack(list, "", 0, 0, n);
        return list;
    }

    private void backTrack(List<String> list, String curr, int open, int close, int max) {
        if (curr.length() == max << 1) {
            list.add(curr);
            return;
        }
        if (open < max)
            backTrack(list, curr + "(", open + 1, close, max);
        if (close < open)
            backTrack(list, curr + ")", open, close + 1, max);
    }
}
