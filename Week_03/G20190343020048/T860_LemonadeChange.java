package main.leetcode_solutions.greedy;

/**
 * @author wenzhuang
 * @date 2019/12/29 8:13 PM
 */
public class T860_LemonadeChange {

    public boolean lemonadeChange(int[] bills) {
        int count5 = 0, count10 = 0;
        for (int bill : bills) {
            if (bill == 5){
                count5++;
            } else if (bill == 10){
                if (count5 >= 1){
                    count5--;
                    count10++;
                } else {
                    return false;
                }
            } else {
                if (count10 >= 1 && count5 >= 1){
                    count10--;
                    count5--;
                } else if (count5 >= 3){
                    count5 -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
