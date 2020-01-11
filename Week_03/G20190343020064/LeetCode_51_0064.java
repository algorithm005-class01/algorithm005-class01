package G20190343020064;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * N皇后
 * </p>
 *
 * @author mingke.yan@hand-china.com 2019-12-27 9:48 上午
 */
public class LeetCode_51_0064 {


    public List<List<String>> result = new ArrayList<>();

    /**
     * 此处可优化 TODO
     * 攻击范围
     */
    public List<String> position = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        this.solve(0, n, new ArrayList<String>());
        return result;
    }


    public void solve(int begin, int n, List<String> list) {
        if (begin == n) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < n; i++) {
            // 校验当前位置是否可放入 不可则continue
            if (position.contains(i + "," + begin)) {
                continue;
            }
            // 放入棋盘 将不可放的位置记录
            list.add(this.generateStr(n, i));
            this.addPosition(i, begin, n);
            // 当前可以放入则嗅探道下一层
            solve(begin + 1, n, list);
            list.remove(list.size() - 1);
            this.removePosition(i, begin, n);
        }
    }

    /**
     * 此处可优化 TODO
     * 通过皇后位置，将攻击范围加入 position
     * 1,2
     * <p>
     * x: 行
     * y: 列
     * n: 纬度
     */
    public void addPosition(int x, int y, int n) {
        for (int i = y, j = 1; i < n; i++) {
            // 计算左边对角线
            if ((x - j) >= 0 && (y + j) < n) {
                position.add((x - j) + "," + (y + j));
            }
            // 计算右边对角线
            if ((x + j) < n && (y + j) < n) {
                position.add((x + j) + "," + (y + j));
            }
            if ((y + j) < n) {
                position.add(x + "," + (y + j));
            }
            j++;
        }
    }

    /**
     * 此处可优化 TODO
     * 通过皇后位置，将攻击范围去除 position
     * 1,2
     * <p>
     * x: 行
     * y: 列
     * n: 纬度
     */
    public void removePosition(int x, int y, int n) {
        for (int i = y, j = 1; i < n; i++) {
            // 计算左边对角线
            if ((x - j) >= 0 && (y + j) < n) {
                position.remove(position.lastIndexOf((x - j) + "," + (y + j)));
            }
            // 计算右边对角线
            if ((x + j) < n && (y + j) < n) {
                position.remove(position.lastIndexOf((x + j) + "," + (y + j)));
            }
            if ((y + j) < n) {
                position.remove(position.lastIndexOf(x + "," + (y + j)));
            }
            j++;
        }
    }

    public String generateStr(int n, int y) {
        char[] str = new char[n];
        for (int i = 0; i < str.length; i++) {
            if (i == y) {
                str[i] = 'Q';
            } else {
                str[i] = '.';
            }
        }
        return new String(str);
    }
}
