import java.util.LinkedList;
import java.util.List;

public class LeetCode_77_0190 {
    private List<List<Integer>> output = new LinkedList<>();
    private int n, k;

    private void backtrack(int first, LinkedList<Integer> curr) {
        if (curr.size() == k) output.add(new LinkedList<>(curr));
        for (int i = first; i < n + 1; i++) {
            curr.add(i);
            backtrack(i + 1, curr);
            curr.removeLast();
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        backtrack(1, new LinkedList<>());
        return output;
    }
}
