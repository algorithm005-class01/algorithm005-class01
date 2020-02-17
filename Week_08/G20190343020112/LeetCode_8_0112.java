class Solution {
    public int myAtoi(String str) {
        int res = 0;
        if (str == null || str.length() == 0) return res;
        int base = (int)'0';
        int index = 0;
        boolean isNegative = false;
        while(index < str.length() && str.charAt(index) == ' ') index++;
        if (index >= str.length()) return res;
        char c = str.charAt(index);
        if (!isDigit(c)) {
            index++;
            if (c == '-') isNegative = true;
            else if (c == '+') ;
            else return res;
        }

        int minBound = Integer.MIN_VALUE / 10, maxBound = Integer.MAX_VALUE /10;
        for (; index < str.length() && isDigit(c = str.charAt(index)); index++) {
            int cv = (int) c - base;
            if (isNegative) {
                if ((res == minBound && cv > 8) || res < minBound ) return Integer.MIN_VALUE;
            } else {
                if ((res == maxBound && cv > 7) || res > maxBound) return Integer.MAX_VALUE;
            }
            res = res * 10 + (isNegative ? -cv : cv);
        }
        return res;
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
}

// class Solution {
//     public int myAtoi(String str) {
//         if (str == null || str.length() == 0) {
//             return 0;
//         }
//         char[] chars = str.toCharArray();
//         boolean isNegative = false;
//         int index = 0;
//         while(index< str.length() && chars[index] == ' ') index++;
//         if (index >= str.length()) return 0;
//         if (chars[index] != '+'  && chars[index] != '-' && chars[index] < '0' && chars[index] > '9') {
//             return 0;
//         }else if(chars[index] == '+') {
//             index++;
//         }else if(chars[index] == '-') {
//             isNegative = true;
//             index++;
//         }else {
//             ;
//         }

//         int max = (1<< 31) - 1 , min = -1 << 31;

//         int maxBound = max / 10, minBound = min / 10;

//         int result = 0;
//         for (; index < chars.length; index++) {
//             char c = chars[index];
//             if (!isDigit(c)) {
//                 break;
//             }
//             int diff = (c - '0');
//             if (isNegative) {
//                 if (-result < minBound || (-result == minBound && diff >= 8)) {
//                     return min;
//                 }
//             }else {
//                 if (result > maxBound || (result == maxBound && diff >= 7)) {
//                     return max;
//                 }
//             }
//             result = result*10 + diff;
            
//         }
//         return isNegative? -result : result;

//     }

//     private boolean isDigit(char c) {
//         return c >= '0' && c <= '9';
//     }
// }