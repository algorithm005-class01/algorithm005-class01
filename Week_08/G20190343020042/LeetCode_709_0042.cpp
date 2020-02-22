lass Solution {
public:
//利用ASCII值大小写之间相差32的性质，遇到大写的字母，加上32就是相应的小写字母。
    string toLowerCase(string str) {
        int len = str.size();
        for(int i = 0;i < len;i++){
            if((str[i] >= 'A')&&(str[i] <= 'Z'))
                str[i] += 32;
        }
        return str;
    }
};