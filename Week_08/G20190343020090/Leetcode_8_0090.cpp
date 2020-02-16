class Solution {
public:
    int myAtoi(string str) {
        unsigned long len = str.length();
        int index = 0;
        while (index < len)
        {
            if (str[index] != ' ')
                break;
            index++;
        }

        if (index == len) 
        {
            return 0;
        }

        int sign = 1;
        if (str[index] == '+') 
            index++;
        else if (str[index] == '-') 
        {
            sign = -1;
            index++;
        }

        long res = 0;
        while (index < len) 
        {
            char curChar = str[index];
            if (curChar < '0' || curChar > '9') 
                break;

            if (res > INT_MAX / 10 || (res == INT_MAX / 10 && (curChar - '0') > INT_MAX % 10)) 
                return INT_MAX;
            if (res < INT_MIN / 10 || (res == INT_MIN / 10 && (curChar - '0') > -(INT_MIN % 10))) 
                return INT_MIN;
                
            res = res * 10 + sign * (curChar - '0');
            index++;
        }
        return res;

    }
};