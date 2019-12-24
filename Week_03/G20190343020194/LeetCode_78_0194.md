# 78. 子集
## 题目
输出一个集合所有子集可能的类型
## 思路
- 使用深度搜索输出所有集合，每次搜索分支都是输出或者不输出。
## 题解
### 使用深度优先搜索
```c
class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> res;
        vector<int> now;
        dfs(nums, 0, now, res);
        return res;
    }
    void dfs(vector<int>& nums, int x, vector<int> &now, vector<vector<int>>& res){
        if(x== nums.size()){
            res.push_back(now);
            return ;
        }
        //每次搜索只有放入集合或者不放入集合两种可能
        dfs(nums, x+1, now, res); // 不放入集合

        now.push_back(nums[x]);
        dfs(nums,x+1, now, res);
        now.pop_back();
        
    }
};
```

### 使用枚举
数组 [1,2,3] 的子集也就是其中的三个元素取与不取的组合。把它想象为二进制的三个 bit 位 1 1 1，那么从 0 0 0 到 1 1 1 的 8 个数，就构成了所有子集的选取情况。比如 0 0 1 表示取第1个元素，0 1 1 表示取前两个元素。

这个是从网上的题解中查找到的解法。感觉挺好的容易理解。