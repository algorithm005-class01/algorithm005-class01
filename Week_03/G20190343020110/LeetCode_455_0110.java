import java.util.Arrays;

/**
 * @Author huangxiong
 * @Date 2019/12/29
 * @Description 分饼干
 **/
public class LeetCode_455_0110 {

    /**
     * 贪心解法
     * @param grid
     * @param size
     * @return
     */
    public int findContentChildren(int[] grid, int[] size) {
        if (grid == null || size == null) return 0;
        Arrays.sort(grid);
        Arrays.sort(size);
        int gi = 0, si = 0;
        while (gi < grid.length && si < size.length) {
            if (grid[gi] <= size[si]) {
                gi++;
            }
            si++;
        }
        return gi;
    }
}
