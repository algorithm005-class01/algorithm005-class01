# 242. 有效的字母异位词
## 题目
[链接]()
## 思路
- 直接使用排序方法再进行对比
- 使用哈希表来记录每个词出现的次数
- 思路和第二种方法类似，可以使用map来存储然后进行map对比是否相同
## 题解
### 直接使用排序算法对比
```c
class Solution {
public:
    bool isAnagram(string s, string t) {
        sort(s.begin(),s.end());
        sort(t.begin(),t.end());
        if(s.compare(t)==0)
            return true;
        else
            return false;   
    }
};
```

### 是用数组hash来判断hash表是否相同
```c
class Solution {
public:
    bool isAnagram(string s, string t) {
       if(s.size()!=t.size())
            return false;
        int ks[256];
        int kt[256];
        memset(ks,0,sizeof(ks));
        memset(kt,0,sizeof(kt));
        for(int i = 0 ; i < s.size(); i++){
            ks[s[i]]++;
            // cout<<  ks[s[i]]<<endl;
        }
        for(int i = 0 ; i < s.size(); i++){
            kt[t[i]]++;
            // cout<<  kt[t[i]]<<endl;
        }
        // cout<<"start compare"<<endl;
        for(int i = 0 ; i < 256; i++){
            // cout << i << " "<< ks[i]<< " " << kt[i]<< endl;
            if(ks[i]!=kt[i])
                return false;
        }
        return true;
    }
}
```