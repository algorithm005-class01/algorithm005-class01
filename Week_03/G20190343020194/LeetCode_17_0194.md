# 17. 电话号码的字母组合
## 题目
输入电话号码，对应的字母组合输出
## 思路
- 这题我能够想到的就是一个通过深度搜来输出所有可能。
## 题解
```c
class Solution {
public:
    char a[10][5] = {
        "",
        "",
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tuv",
        "wxyz",
    };
    vector<string> letterCombinations(string digits) {
        
        vector<string> res;
        /*这里需要注意特殊的输入有一个空，假设digits为空，则输出也为空集， 如果不进行这个条件判断会有一个测试用例无法通过”*/
        if(digits=="")
            return res;
        string index = "";
        dfs(res, 0, index, digits);
        return res;
    }
    void dfs(vector<string>& res,int now, string &index, string& digits){
        if(now==digits.size()){
            res.push_back(index);
            return;
        }
        int num = digits[now]-'0';
        for(int i = 0 ; i < strlen(a[num]); i++){
            index.push_back(a[num][i]);
            dfs(res, now+1, index, digits);
            index.pop_back();
        }
    }

};
```
