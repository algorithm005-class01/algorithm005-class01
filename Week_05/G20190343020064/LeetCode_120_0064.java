package G20190343020064;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 三角形最小路径和
 * </p>
 *
 * @author mingke.yan@hand-china.com 2020-01-10 11:21 下午
 */
public class LeetCode_120_0064 {


    /**
     * 自底向上 迭代方式
     *
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0 || triangle.get(0).size() == 0) {
            return 0;
        }
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                triangle.get(i).set(j, Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)) + triangle.get(i).get(j));
            }
        }
        return triangle.get(0).get(0);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////


    public Map<String, Integer> map = new HashMap();

    /**
     * 自顶向下 分治递归方式
     *
     * @param triangle
     * @return
     */
    public int minimumTotal2(List<List<Integer>> triangle) {
        return recursive(0, 0, triangle);
    }

    public int recursive(int level, int index, List<List<Integer>> triangle) {
        if (level == triangle.size() - 1) {
            return triangle.get(level).get(index);
        }

        if (map.get(level + "," + index) != null) {
            return map.get(level + "," + index);
        }
        int left = recursive(level + 1, index, triangle);
        int right = recursive(level + 1, index + 1, triangle);
        int value = Math.min(left, right) + triangle.get(level).get(index);
        map.put(level + "," + index,value);
        return value;
    }

}
