# 91. 解码方法

## 解法

### 递归

```
public int numDecodings(String s) {
    return getAns(s, 0);
}

private int getAns(String s, int start) {
        if (start == s.length()) {
        return 1;
    }
    if (s.charAt(start) == '0') {
        return 0;
    }
    int ans1 = getAns(s, start + 1);
    int ans2 = 0;
    if (start < s.length() - 1) {
        int ten = (s.charAt(start) - '0') * 10;
        int one = s.charAt(start + 1) - '0';
        if (ten + one <= 26) {
            ans2 = getAns(s, start + 2);
        }
    }
    return ans1 + ans2;
}
```

### 动态规划

```
public int numDecodings5(String s) {
    int len = s.length();
    int end = 1;
    int cur = 0;
    if (s.charAt(len - 1) != '0') {
        cur = 1;
    }
    for (int i = len - 2; i >= 0; i--) {
        if (s.charAt(i) == '0') {
            end = cur;//end 前移
            cur = 0;
            continue;
        }
        int ans1 = cur;
        int ans2 = 0;
        int ten = (s.charAt(i) - '0') * 10;
        int one = s.charAt(i + 1) - '0';
        if (ten + one <= 26) {
            ans2 = end;
        }
        end = cur; //end 前移
        cur = ans1 + ans2;

    }
    return cur;
}
```