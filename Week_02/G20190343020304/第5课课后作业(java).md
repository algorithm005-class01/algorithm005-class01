### 课后第一题- 有效的字母异位词

给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

例:

```
输入: s = "anagram", t = "nagaram"
输出: true

输入: s = "rat", t = "car"
输出: false

```
说明:
你可以假设字符串只包含小写字母。


方法一
```java
 public boolean Solution(String s, String t) {
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(t1);

        return Arrays.equals(s1, t1);
    }
```

方法二

```java
 public boolean Solution(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] temp = new int[26];
        for (int i = 0; i < s.length(); i++) {
            temp[s.charAt(i) - 'a']++;
            temp[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < s.length(); i++) {
            if (temp[s.charAt(i) - 'a'] != 0) {
                return false;
            }
        }

        return true;
    }
```

