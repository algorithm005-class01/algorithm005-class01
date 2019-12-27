package G20190343020064;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <p>
 * 组合
 * </p>
 *
 * @author mingke.yan  2019-12-21 11:51 下午
 */
public class LeetCode_77_0064 {

    private List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0 || n < k) {
            return list;
        }
        traversal(n,1,k,new Stack<>());
        return list;
    }

    public void traversal(int n, int begin, int k, Stack<Integer> stack) {
        if (stack.size() == k) {
            list.add(new ArrayList<>(stack));
            return;
        }
        //===============================================================================
        //  这里用 stack 是为了 缓存上一层的数据
        //  比如当 第一层循环取 1 时，下层的 traversal  则是  2，3，4
        //  所以 有 stack =  (1,2) (1,3) (1,4) 的情况
        //  如果这里不用栈 则会出现 (1,2) 之后到 (3,4) 的情况。
        //===============================================================================
        for(int i = begin; i <= n; i++) {
            stack.push(i);
            traversal(n,i + 1,k,stack);
            stack.pop();
        }
    }
}
