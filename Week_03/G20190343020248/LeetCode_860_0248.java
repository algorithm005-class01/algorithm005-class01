/**
 * 柠檬水找零问题
 * 贪心思想
 * 总是优先找零10元，如果没有10元或找零金额小于10元，才找零5元，因为2个5元可以组成10元，适用性更强。
 */
public class LeetCode_860_0248 {

    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5)
                five++;
            else if (bill == 10) {
                if (five == 0) return false;
                five--;
                ten++;
            } else {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}