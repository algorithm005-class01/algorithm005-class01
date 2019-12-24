# 169. 多数元素
## 题目
找出一个数组中出现次数最多的元素。
## 思路
- 使用hash表统计每个次出现的次数
- 出现在分治的课里，理论上应该是可以用这个方法，往这方面想。(看了题解得出)。
- 看了题解中有一种叫做投票法的题解。嗯很神奇。
## 题解
### 使用map统计
```c
int baoli(vector<int>& nums){
        map<int, int> numsmap;
        for(int i=0 ; i < nums.size(); i++) {
            if(numsmap.find(nums[i]) == numsmap.end()){
                numsmap.insert(make_pair(nums[i],1));
            }
            else {
                numsmap[nums[i]]++;
            }  
        }
        int max = 0;
        int res ;
        map<int, int>::iterator it = numsmap.begin();
        while (it != numsmap.end()) {
            if (it->second > max) {
                max = it->second;
                res = it->first;
            }
            it++;
        }
        return res;
    }
```
### 分治
### 投票法
如果我们把众数记为 +1+1 ，把其他数记为 -1−1 ，将它们全部加起来，显然和大于 0 ，从结果本身我们可以看出众数比其他数多。
> 这个投票法虽然非常巧妙，但是必须要满足大于n/2这个条件才行。
```c
int vote(vector<int>& nums) {
        int sum = 0;
        int candidate = nums[0];
        for(int i = 0 ; i < nums.size() ; i++){
            if(sum ==0){
                candidate = nums[i];
            }
            sum += (nums[i]==candidate) ? 1:-1;
        }
        return candidate;
    }
```

## 想法心得
这题其实题解中还写了很多很有启发的代码。
- 随机法（由于出现次数大于n/2所以随机挑选一个来检测是否是众数也是一个不错的方法）
- 排序法（排序完成后中间的数一定是众数）
