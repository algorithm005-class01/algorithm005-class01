package week_03.commit;

// 860. 柠檬水找零
// https://leetcode-cn.com/problems/lemonade-change/description/
public class Solution_860 {

    public static boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int i : bills) {
            if (i == 5) five++;
            else if (i == 10) {
                five--;
                ten++;
            } else if (ten > 0) {
                ten--;
                five--;
            } else five -= 3;
            if (five < 0)
                return false;
        }
        return true;
    }
}
