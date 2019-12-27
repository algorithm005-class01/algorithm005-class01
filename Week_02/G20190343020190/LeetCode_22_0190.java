import java.util.ArrayList;
import java.util.List;

public class LeetCode_22_0190 {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backTrack(ans, "", 0, 0, n);
        return ans;
    }

    public void backTrack(List<String> ans, String curr, int open, int close, int max) {
        if (curr.length() == max << 1) {
            ans.add(curr);
            return;
        }
        if (open < max)
            backTrack(ans, curr + "(", open + 1, close, max);
        if (close < open)
            backTrack(ans, curr + ")", open, close + 1, max);
    }
}
