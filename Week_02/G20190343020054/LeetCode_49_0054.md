# 49. 字母异位词分组

> 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
>
> 示例:
> ```
> 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
> 输出:
> [
>   ["ate","eat","tea"],
>   ["nat","tan"],
>   ["bat"]
> ]
> ```
>
> 说明：
>
> 所有输入均为小写字母。
> 不考虑答案输出的顺序。

## 解题思路

### 1. 排序数组分类
  
当且仅当它们的排序字符串相等时，两个字符串是字母异位词。

我们在本地维护一个 HashMap 的映射（String -> List）。

每个 key 键是字符串排序后的值，value 中的 list 存储的是原来的 String。

复杂度分析

时间复杂度：O(NKlogK) 其中 N 是 strs 的长度，而 K 是 strs 中字符串的最大长度。当我们遍历每个字符串时，外部循环具有的复杂度为 O(N)。然后，我们在 O(KlogK) 的时间内对每个字符串排序。

空间复杂度：O(NK)

```java
public List<List<String>> groupAnagrams(String[] strs) {
    if (strs.length == 0 ) return new ArrayList<>();
    HashMap<String, List<String>> ans = new HashMap<>();
    for (int i = 0; i < strs.length; i++) {
        char[] ca = strs[i].toCharArray();
        Arrays.sort(ca);
        String key = String.valueOf(ca);
        if (!ans.containsKey(key)) {
            ans.put(key, new ArrayList());
        }
        ans.get(key).add(strs[i]);
    }
    return new ArrayList<>(ans.values());
}
```

### 2. 按计数分类

当且仅当它们的字符计数(每个字符出现的次数)相同时，两个字符串是异位词。

将每字符串s替换为字符数 count，由 26 个非负整数组成，表示 a,b,c 等的数量。使用这些计数作为哈希映射的基础。

在Java中，使用字符数 count 的散列化表示将是一个用 `**#**` 字符分隔的字符串。

例如：`aabbcc` 将表示为 `＃1＃2＃3＃0＃0＃0 ...＃0`，其中总共有 26 个条目。

复杂度分析

时间复杂度：O(NK)，其中 N 是 strs 的长度，而 K 是 strs 中字符串的最大长度。计算每个字符串的字符串大小是线性的，统计每个字符串。

空间复杂度：O(NK)，排序存储在 ans 中的全部信息内容。

```java
public List<List<String>> groupAnagrams(String[] strs) {
    if (strs.length == 0) return new ArrayList<>();
    HashMap<String, List<String>> ans = new HashMap<>();
    int[] counter = new int[26];
    for (String s : strs) {
        Arrays.fill(counter, 0);
        for (int j = 0; j < s.length(); j++) {
            counter[s.charAt(j) - 'a']++;
        }
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i < 26; i++) {
            sb.append("#");
            sb.append(counter[i]);
        }
        String key = sb.toString();
        if (!ans.containsKey(key)) ans.put(key,new ArrayList<>());
        ans.get(key).add(s);
    }

    return new ArrayList<>(ans.values());
}
```

### 3. 质数相乘

> 算术基本定理，又称为正整数的唯一分解定理，即：每个大于1的自然数，要么本身就是质数，要么可以写为2个以上的质数的积，而且这些质因子按大小排列之后，写法仅有一种方式。

用一个数组存储一个质数表，prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};

然后每一个字符串的字符 - 'a'，然后取 prime 中对应的质数，把他们累乘。

比如：abc -> a - 'a', b - 'a', c - 'a'，即 0,1,2 对应的叔叔是2,3,5，乘积为 2*3*5 = 30，把 abc 映射到 30 上。

```java
public List<List<String>> groupAnagrams(String[] strs) {
    if (strs.length == 0) return new ArrayList<>();
    HashMap<Integer, List<String>> ans = new HashMap<>();
    int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
    for(int i = 0; i < strs.length; i++) {
        int key = 1;
        for(int j = 0; j < strs[i].length(); j++) 
            key*= prime[strs[i].charAt(j) - 'a'];
        
        if (!ans.containsKey(key)) ans.put(key, new ArrayList<>());
        ans.get(key).add(strs[i]);
    }
    return new ArrayList<>(ans.values());

}
```