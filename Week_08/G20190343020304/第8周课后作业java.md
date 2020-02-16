### 课后第一题- 字符串中的第一个唯一字符


给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。

例:

```
s = "leetcode"
返回 0.

s = "loveleetcode",
返回 2.

```
## 题解
```java
class Solution {
    public int firstUniqChar(String s) {
        int[] array = new int[26];
        for(int i =0;i<s.length();i++){
            array[s.charAt(i) - 'a']++;
        }
        for(int i =0;i<s.length();i++){
            if(array[s.charAt(i) - 'a']<2){
                return i;
            }
        }
        return -1;
    }
}

        
```

课后第二题- [翻转字符串里的单词](https://leetcode-cn.com/problems/reverse-words-in-a-string/)

给定一个字符串，逐个翻转字符串中的每个单词。

例:

```
输入: "the sky is blue"
输出: "blue is sky the"

```

## 题解
```java
class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] temp=s.split(" +");
        StringBuilder res = new StringBuilder();
        for(int i =temp.length -1;i>=0;i--){
            res.append(temp[i]);
            res.append(' ');
        }
        return res.toString().trim();
    }
}
```

课后第三题- [不同路径 II](https://leetcode-cn.com/problems/unique-paths-ii/)

一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？

例:

```
输入:
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
输出: 2
解释:
3x3 网格的正中间有一个障碍物。
从左上角到右下角一共有 2 条不同的路径：
1. 向右 -> 向右 -> 向下 -> 向下
2. 向下 -> 向下 -> 向右 -> 向右


```

## 题解
```java
class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] temp=s.split(" +");
        StringBuilder res = new StringBuilder();
        for(int i =temp.length -1;i>=0;i--){
            res.append(temp[i]);
            res.append(' ');
        }
        return res.toString().trim();
    }
}
```

课后第四题- [找到字符串中所有字母异位词](https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/)

给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。

字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。

## 说明

* 字母异位词指字母相同，但排列不同的字符串。
* 不考虑答案输出的顺序。

例:

```
输入:
s: "cbaebabacd" p: "abc"

输出:
[0, 6]

解释:
起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。

```

## 题解
```java
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] temp = new int[26];
        int[] temp2 = new int[26];
        ArrayList<Integer> ret = new ArrayList<Integer>();
        int l = p.length();
        if( s.length() == 0 || s.length()<l) return ret;
        for(int i = 0;i<l;i++){
            temp[s.charAt(i) - 'a']++;
            temp2[p.charAt(i) - 'a']++;
        }
        
        for(int i =l;i<s.length();i++){
            if(check(temp,temp2)){
                ret.add(i-l);
            }
            temp[s.charAt(i) - 'a']++;
            temp[s.charAt(i -l) - 'a']--;
              System.out.println( temp[s.charAt(i) - 'a']);
        }

        if(check(temp,temp2)){
          
            ret.add(s.length() -l);
        }

        return ret;

    }

    public boolean check(int[] array,int[] array2){
           for(int i = 0;i<array2.length;i++){
               if(array2[i] !=array[i]){
                   return false;
               }
           }
           return true;
    }
}
```

课后第五题- [最长有效括号](https://leetcode-cn.com/problems/longest-valid-parentheses/)

给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。

例:

```
输入: "(()"
输出: 2
解释: 最长有效括号子串为 "()"

```

## 题解
```java
class Solution {
    public int longestValidParentheses(String s) {
        int maxlen = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }else{
                stack.pop();
                if(stack.empty()){
                    stack.push(i);
                }else{
                    maxlen=  Math.max(maxlen,i-stack.peek());
                }
                
            }
        }
        return maxlen;
    }
}    
```

