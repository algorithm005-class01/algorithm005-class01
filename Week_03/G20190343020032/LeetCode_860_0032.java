class Solution {
    public boolean lemonadeChange(int[] bills) {
        int count5 = 0;
        int count10 = 0;
        for (int bill : bills) {
            if (bill == 5) {
                count5++;
            } else if (bill == 10) {
                count10++;
                count5--;
            } else {
                if (count10 >= 1) {
                    count10 -= 1;
                    count5--;
                } else {
                    count5 -= 3;
                }
            }
            if (count5 < 0 || count10 < 0) {
                return false;
            }
        }
        return true;
    }
}