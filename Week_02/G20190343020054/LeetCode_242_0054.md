# 242. 有效的字母异位词

> 异位词：两个字符串中，字母出现的次数一致，但顺序不一样。
> 
> 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
>
> 示例 1:
> 
> ```
> 输入: s = "anagram", t = "nagaram"
> 输出: true
> 
> 示例 2:
> 
> ```
> 输入: s = "rat", t = "car"
> 输出: false
> 说明:
> 你可以假设字符串只包含小写字母。
> ```
> 
> 进阶:
> 
> 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？

## 解法思路

### 1. 暴力求解

将字符串，排序，然后比较排序后的是否相同

复杂度分析

时间复杂度：O(nlogn)，假设 n 是 s 的长度，排序成本 O(nlogn) 和比较两个字符串的成本 O(n)。排序时间占主导地位，总体时间复杂度为 O(nlogn)。

空间复杂度：O(n)


```java
public static boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) return false;
    char[] s1 = s.toCharArray();
    char[] s2 = t.toCharArray();
    Arrays.sort(s1);
    Arrays.sort(s2);
    return Arrays.equals(s1, s2);
}
```

### 2. 哈希表

为了检查 t、s 是否是异位词，可以计算两个字符串中每个字母的出现次数并进行比较。因为 S 和 T 都只包含 A-Z 的字母，所以使用一个简单的 26 位计数器表就足够了。

可以用一个计数器表计算 s 字母的频率，用 t 减少计数器表中的每个字母的计数器，然后检查计数器是否回到零。

```java
public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) return false;
    int[] counter = new int[26];
    for (int i = 0; i < s.length(); i++) {
        counter[s.charAt(i) - 'a']++;
        counter[t.charAt(i) - 'a']--;
    }
    for (int count : counter) {
        if (count != 0) {
            return false;
        }
    }
    return true;
}
```

或者可以先用计数器表计算 s，然后用 t 减少计数器表中的每个字母的计数器。如果在任何时候计数器低于零，我们知道 t 包含一个不在 s 中的额外字母，并立即返回 FALSE。

```java
public boolean isAnagram2(String s, String t) {
    if (s.length() != t.length()) return false;
    int[] counter = new int[26];
    for (int i = 0; i < s.length(); i++) {
        counter[s.charAt(i) - 'a']++;
    }
    for (int i = 0; i < t.length(); i++) {
        counter[t.charAt(i) - 'a']--;
        if ( counter[t.charAt(i) - 'a'] < 0) {
            return false;
        }
    }
    return true;
}
```

复杂度分析

时间复杂度：O(n)。时间复杂度为 O(n) 因为访问计数器表是一个固定的时间操作。

空间复杂度：O(1)。尽管我们使用了额外的空间，但是空间的复杂性是 O(1)，因为无论 N 有多大，表的大小都保持不变。
