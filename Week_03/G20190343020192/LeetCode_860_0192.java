public class LeetCode_860_0192 {
    // 860. 柠檬水找零 https://leetcode-cn.com/problems/lemonade-change/submissions/

    /*
    解题：
    1. 分别记录5元、10元数量
    2. 收到5元：5元数量+1
    3. 收到10元：10元数量+1、5元数量-1
    4. 收到20元：
      4.1. 10元数量 > 0：10元数量-1、5元数量-1
      4.2. 10元数量 <= 0：5元数量-3
    5. 最后判断5元数量是否小于0
      5.1. < 0 : 没钱找零
      5.2. >= 0 : 可以找零
     */
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) five++;
            else if (bill == 10) {ten++; five--;}
            else if (ten > 0) { ten--; five--;}
            else {five -= 3;}
            if (five < 0) return false;
        }
        return true;
    }
}
