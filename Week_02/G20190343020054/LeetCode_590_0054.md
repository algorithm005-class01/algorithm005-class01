# 590. N叉树的后序遍历

> 给定一个 N 叉树，返回其节点值的后序遍历。
>
> 例如，给定一个 3叉树 :
> 
> ![](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/12/narytreeexample.png) 
> 
> 返回其后序遍历: [5,6,3,2,4,1]

## 解题思路

### 1. 递归

```java
public List<Integer> postorder(Node root) {
    List<Integer> res = new ArrayList<>();
    if (root == null) return res;
    helper(root, res);
    return res; 
}

private void helper(Node node, List<Integer> res) {
    if (root == null) return;
    for (Node n: node.children) {
        helper(n, res);
    }
    res.add(node.val);
}
```

### 2. 迭代

这是二叉树后序遍历的变形。

在后序遍历中，我们会先遍历一个节点的所有子节点，再遍历这个节点本身。

例如当前的节点为 u，它的子节点为 v1, v2, v3 时，那么后序遍历的结果为 [children of v1], v1, [children of v2], v2, [children of v3], v3, u。我们将这个结果反转，可以得到 u, v3, [children of v3]', v2, [children of v2]', v1, [children of v1]'，其中 [a]' 表示 [a] 的反转。

此时结果和前序遍历非常类似，只不过前序遍历中对子节点的遍历顺序是 v1, v2, v3，而这里是 v3, v2, v1。

可以使用和 N叉树的前序遍历 相同的方法，使用一个栈来得到后序遍历。

首先把根节点入栈。当每次我们从栈顶取出一个节点 u 时，就把 u 的所有子节点顺序推入栈中。例如 u 的子节点从左到右为 v1, v2, v3，那么推入栈的顺序应当为 v1, v2, v3，这样就保证了下一个遍历到的节点（即 u 的第一个子节点 v3）出现在栈顶的位置。在遍历结束之后，把遍历结果反转，就可以得到后序遍历。

```java
public List<Integer> preorder(Node root) {
    LinkedList<Integer> output = new LinkedList<>();
    if (root == null) return res;
    LinkedList<Node> stack = new LinkedList<>();
    stack.add(root);
    while (!stack.isEmpty()) {
      Node curr = stack.pollLast();
      output.addFirst(curr.val);
      for (Node n : curr.children) {
        if (n != null) {
          stack.add(n);
        }
      }
    }
    return output;
}
```