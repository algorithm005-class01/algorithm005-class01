学习笔记

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