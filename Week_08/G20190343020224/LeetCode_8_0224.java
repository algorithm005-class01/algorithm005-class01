class Solution {
    public int myAtoi(String str) {
        int index = 0;
        while (index < str.length() && str.charAt(index) == ' ') {
            index++;
        }
        if (index == str.length()) {
            return 0;
        }
        boolean positive = true;
        if (str.charAt(index) == '+') {
            positive = true;
            index++;
        } else if (str.charAt(index) == '-') {
            positive = false;
            index++;
        }

        int val = 0;
        while (index < str.length()) {
            if (str.charAt(index) < '0' || str.charAt(index) > '9') {
                break;
            }
            int num = str.charAt(index++) - 48;
            if (val > Integer.MAX_VALUE / 10 || (val == Integer.MAX_VALUE / 10 && num > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (val < Integer.MIN_VALUE / 10 || (val == Integer.MIN_VALUE / 10 && num > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }
            val = val * 10 + num * (positive ? 1 : -1);
        }

        return val;
    }
}