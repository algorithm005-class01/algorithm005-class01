学习笔记



## 第三周学习总结-代码模板及其梳理思路


### 使用二分查找, 寻找一个半有序数组中间无序的地方

```java
class Solution {
        /*查找最大值和最新值的位置*/
        public int[] find(int[] nums) {
            if (nums == null || nums.length <= 1) {
                return new int[]{-1};
            }
            int lo = 0;
            int hi = nums.length - 1;
            int start = nums[0];
            if (start < nums[hi]) {
                return new int[]{-1};
            }
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                if (nums[mid] > nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            return new int[]{lo - 1, lo};
        }
}
```

最小值位置-1 即可

### 递归

代码模板
```java
class Solution {
public void recur(int level, int param) {
        //terminator
        if (level > MAX_LEVEL) {
            return;
        }
        // process current logic

        process(level, param);
        //drill down
        recur(level + 1, newParam);
    }
}
```

1 终止条件.  即为递归的结束条件, 
2. 业务逻辑处理
3. 进入下次递归

例子: 22 括号生成问题

```java
class Solution {
 public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        this.generate("", res, n, 0, 0);
        return res;
    }

    private void generate(String s, List<String> res, int level, int left, int right) {
        // terminator
        if (s.length() == level * 2) {
            res.add(s);
            return;
        }
        //process + drill down
        if (left < level) {
            generate(s + "(", res, level, left + 1, right);
        }
        if (right < left) {
            generate(s + ")", res, level, left, right + 1);
        }
    }
}
```

### 分治

```java
class Solution {
public void divide_conquer(int problem, int param, int param1) {
        // terminator 子问题结束条件
        // perpare data 准备数据 划分子问题
        // conquer subproblems  求解子问题
        // process and generate the final result 合并子问题
        // revert the current level states 处理当前层的状态
    }
}
```

例子 50 Pow(x,n)

分治体现在将大问题分解成子问题. 求解子问题, 然后将子问题的接合并. 大问题就得到了解决. 

```java
class Solution {
public double myPow(double x, int n) {
        int N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return fastPow(x, N);
    }

    private double fastPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double sub = this.fastPow(x, n / 2);
        if (sub % 2 == 0) {
            return sub * sub;
        }else {
            return sub * sub * x;
        }
    }
}
```

### 回溯

回溯更像是是递归一种应用方法. 按照一条路线深入求解. 如果得不到解, 退回上一个节点, 继续试.


例子: 78 子集问题

枚举数组元素0时, 1时 2时  3时. 各种情况

```java
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        subsetsHelper(ans, new ArrayList<>(), 0, nums);
        return ans;

    }

    private void subsetsHelper(List<List<Integer>> ans, ArrayList<Integer> integers, int level, int[] nums) {
        if (level == nums.length) {
            ans.add(new ArrayList<>(integers));
            return;
        }
        subsetsHelper(ans, integers, level + 1, nums);
        integers.add(nums[level]);
        subsetsHelper(ans, integers, level + 1, nums);
        integers.remove(integers.size() - 1);
    }
}
```


### DFS

```java
class Sulotion {

}
```


### BFS

### 贪心

贪心算法就是每次都选局部最优. 希望得到的结果时全局最优的.  

### 二分查找



例子: 69 x的平方根

```java
class Sulotion {
public int mySqrt(int x) {
        int left = 1, right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == x / mid) {
                return mid;
            } else if (mid < x / mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

}
```


## leetcode刷题思路笔记

### https://leetcode-cn.com/problems/powx-n/ 50 Pow(x, n)

解题思路: 递归 分治

如果计算  2^10 = 2^5+2^5; 2^9 = 2^4+2^4+2^1;

由此可以将n次想成的O(n)复杂度变成O(logn);

### https://leetcode-cn.com/problems/subsets/ 78 子集

解题思路: 递归 回溯

逐层枚举的思路. 每层的选择都是选择和不选择. 当知道不到结果时, 回溯

### https://leetcode-cn.com/problems/majority-element/ 169 多数元素

解题思路: hash表法. 使用哈希表记录元素出现的次数. 最后按照次数排序. 取出次数大于n/2的

解题思路: 分治法: 
分别在前半数组找众数left和在后半部分找众数right. 当left==right时. 说明左右数组找到的结果一致. 返回left
当left和right不等. 则遍历左右数组. 统计次数. 次数多这 胜出.

### https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/ 17 电话号码的字母组合

解题思路: 递归

使用hash表 做号码和字母映射. 

按照层级枚举 直到level == digits.length()


### https://leetcode-cn.com/problems/n-queens/ 51 N 皇后问题

解题思路: 递归+回溯

### https://leetcode-cn.com/problems/word-ladder/ 127 单词接龙

解题思路: DFS

将思路装换为从beginWord到endWord的路径搜索问题.  路径列表是WordList. 在WordList中搜索路径. 能够从bw->ew.

由于题意. 希望可以从bw和ew端一起开始搜索. 直到会和.  将bw和ew分别放入bws和ews的不重复容器中. 遍历bws.取得单词s,将s中的字母依次替换, 检查是否在wl中存在并且在eds中也存在. 路径所搜索完成. 返回层级
否则将单词添加到路径列表中. 继续向下搜索. 直到找到ew.  


之所以叫DFS. 在整个递归树中 依次沿着节点深入

### https://leetcode-cn.com/problems/lemonade-change/ 860 柠檬水找零

解题思路: 统计5元的个数.  当五元<0 说明找不开

遍历数组  遇见5元的 five++ 遇见10元的 five-- ten++ 遇见20的. 要不就是five-- ten-- 要不就是 five-3

如果five < 0 return false 

否则 true;

### https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/ 122 买卖股票的最佳时机 II

解题思路 贪心  计算最大利润

只要今天-昨天的利润>0 就在利润profit+今天的利润. 这样得到的结果就是最大利润


### https://leetcode-cn.com/problems/assign-cookies/ 455 分发饼干

解题思路: 贪心

对两个数组排序. 胃口g  饼干大小s. g<=s  孩子个数+1


### https://leetcode-cn.com/problems/search-a-2d-matrix/ 74. 搜索二维矩阵

解题思路: 二分查找

一个m*n二维有序矩阵 可以转成从0开始到m*n-1 的数组. 

所以 left = 0 right = m*n-1;

``row = idx / n ， col = idx % n``





