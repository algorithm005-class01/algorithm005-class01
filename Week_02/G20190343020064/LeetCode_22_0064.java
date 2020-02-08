package G20190343020064;



import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 括号生成
 * </p>
 *
 * @author mingke.yan@hand-china.com 2020-01-07 7:39 下午
 */
public class LeetCode_22_0064 {

    public List<String> result = new ArrayList();

    public List<String> generateParenthesis(int n) {
        int count = 2 * n;
        recursive(new char[count], 0, 0, 0);
        return result;
    }

    /**
     * 左右括号数量等于 n
     * @param str
     * @param index
     * @param leftCount
     * @param rightCount
     */
    public void recursive(char[] str, int index, int leftCount, int rightCount) {
        if (index == str.length) {
            result.add(new String(str));
            return;
        }
        if (leftCount < str.length / 2) {
            str[index] = '(';
            recursive(str, index + 1, leftCount + 1, rightCount);
        }
        //===============================================================================
        //  当右括号数量 < 左括号数量 时 才能选择右括号
        //===============================================================================
        if (rightCount < leftCount && rightCount < str.length / 2) {
            str[index] = ')';
            recursive(str, index + 1, leftCount, rightCount + 1);
        }
    }

}
