import java.util.ArrayList;
import java.util.List;

/**
 * @Author huangxiong
 * @Date 2019/12/19
 * @Description
 **/
public class LeetCode_77_0110 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combs = new ArrayList<List<Integer>>();
        combine(combs, new ArrayList<Integer>(), 1, n, k);
        return combs;
    }

    /**
     * 递归
     *
     * @param combs
     * @param comb
     * @param start
     * @param n
     * @param k
     */
    public void combine(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k) {
        if (k == 0) {
            combs.add(new ArrayList<Integer>(comb));
            return;
        }
        for (int i = start; i <= n; i++) {
            comb.add(i);
            combine(combs, comb, i + 1, n, k - 1);
            comb.remove(comb.size() - 1);
        }
    }

    public static void main(String[] args) {
        LeetCode_77_0110 leetCode_77_0110 = new LeetCode_77_0110();
        System.out.println(leetCode_77_0110.combine(4, 2));
    }
}
