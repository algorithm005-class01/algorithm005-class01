学习笔记

[TOC]

## 切题四件套

- Clarification
- Possible solutions
  - compare (time/space)
  - optimal 
- Coding
- Test cases

## 精通一个领域

- Chunk it up
- Deliberate Practicing
- Feedback
  - 及时反馈
  - 主动反馈
  - 被动反馈

## 五毒神掌

## 自顶向下的编程方式

- https://markhneedham.com/blog/2008/09/15/clean-code-book-review/
- https://leetcode-cn.com/problems/valid-palindrome/

## Big O notation

### O(1)

```java
int n = 1000;
System.out.println("Hey - your input is: " + n);

int n = 1000;
System.out.println("Hey - your input is: " + n);
System.out.println("Hmm.. I'm doing more stuff with: " + n);
System.out.println("And more: " + n);
```

### O(n)

```java
for (int i = 1; i <= n; i++) {
    System.out.println("Hey - I'm busy looking at: " + i);
}
```

### O(n^2)

```java
for (int i = 1; i <= n; i++) { 
    for (int j = 1; j <=n; j++) {
	    System.out.println("Hey - I'm busy looking at: " + i + " and " + j);
	} 
}
```

### O(log(n))

```java
for (int i = 1; i < n; i = i * 2) {
    System.out.println("Hey - I'm busy looking at: " + i);
}
```

### O(k^n)

```java
int fib(int n) {
    if (n <= 2) return n;
    return fib(n - 1) + fib(n - 2);
}
```

## 递归

### Master Theorem

For integer constants a ≥ 1 and b > 1, and the function f with f(n) ∈ Θ(n^d ), d ≥ 0, the recurrence

![](https://wikimedia.org/api/rest_v1/media/math/render/svg/2f5661cc61a3a08b59ef5b55309cd1e4d4514815)

(with T(1) = c) has solutions, and

![](https://img-blog.csdn.net/20170610164415496?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvVW9NX1hpYW9TaHVhaVNodWFp/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)



