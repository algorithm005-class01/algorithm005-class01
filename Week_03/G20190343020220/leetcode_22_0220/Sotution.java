package Week_03.G20190343020220.leetcode_22_0220;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Darcy
 * @date 2019-12-28 14:25
 */
public class Sotution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        this.generate("", res, n, 0, 0);
        return res;
    }

    private void generate(String s, List<String> res, int level, int left, int right) {
        if (s.length() == level * 2) {
            res.add(s);
            return;
        }
        if (left < level) {
            generate(s + "(", res, level, left + 1, right);
        }
        if (right < left) {
            generate(s + ")", res, level, left, right + 1);
        }
    }


}
