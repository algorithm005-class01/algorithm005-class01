import java.util.ArrayList;
import java.util.List;

/**
 * @Author huangxiong
 * @Date 2019/12/18
 * @Description
 **/
public class LeetCode_22_0110 {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generate(0, 0, n, "", list);
        return list;
    }

    public void generate(int left, int right, int n, String s, List<String> list) {
        //terminator
        if (right == n && left == n) {
            list.add(s);
            return;
        }

        //process current logic

        //drill down
        if (left < n)
            generate(left + 1, right, n, s + "(", list);
        if (left > right)
            generate(left, right + 1, n, s + ")", list);
        //reverse states
    }

    public static void main(String[] args) {
        LeetCode_22_0110 leetCode_22_0110 = new LeetCode_22_0110();
        System.out.println(leetCode_22_0110.generateParenthesis(3));
    }
}
