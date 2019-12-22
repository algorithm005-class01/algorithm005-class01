# 94. 二叉树的中序遍历

> 给定一个二叉树，返回它的中序 遍历。
>
> 示例:
> 
> ```
> 输入: [1,null,2,3]
>    1
>     \
>      2
>     /
>    3
> 
> 输出: [1,3,2]
> ```
> 
> 进阶: 递归算法很简单，你可以通过迭代算法完成吗？

## 解题思路

### 1. 递归

首先递归左子树，然后左子树为null时，添加，再递归右子树。

```java
public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    helper(root, res);
    return res;
}

private void helper(TreeNode root, List<Integer> res) {
    if (root != null) {
        if (root.left != null) {
            helper(root.left, res);
        }
        res.add(root.val);
        if (root.right != null) {
            helper(root.right, res);
        }
    }
}
```

### 2. 基于栈的遍历

本地维护一个栈 stack，从开始存储左节点。

```java
public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    TreeNode curr = root;
    while (curr != null || !stack.isEmpty()) {
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
        curr = stack.pop();
        res.add(curr.val);
        curr = curr.right;
    }

    return res;
}
```

### 3. 莫里斯遍历

step1：将当前节点的 current 初始化为根节点

step2：while current 不为空，

若 current 没有左子节点
    a. 将 current 添加到输出
    b. 进入右子树，即，current = current.right
否则
    a. 在current的左子树中，令 current 成为最右侧节点的右节点。
    b. 进入左子树，亦即，current = current.left

举例：

```
          1
        /   \
       2     3
      / \   /
     4   5 6

```

首先，1是根节点，所以将current初始化为1。1有左节点2，current的左子树是

```
         2
        / \
       4   5     
```

在此左子树中最右侧的节点是 5，于是将current(1)变为5的右子节点。

令 current = current.left（curr = 2）。

现在二叉树的形状为

```
         2
        / \
       4   5
            \
             1
              \
               3
              /
             6
```
对于 current(2)，其中左子节点为 4，继续上述过程。

```
        4
         \
          2
           \
            5
             \
              1
               \
                3
               /
              6

```

由于 4 没有左子节点，添加 4 为输出，接着依次添加2,5,1,3。节点3有子节点6 故重复以上过程。

结果最后为[4,2,5,1,6,3]

```java
public List < Integer > inorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    TreeNode curr = root;
    TreeNode pre;
    while (curr != null) {
        if (curr.left == null) {
            res.add(curr.val);
            curr = curr.right;
        } else {
            pre = curr.left;
            while (pre.right != null) {
                pre = pre.right;
            }
            pre.right = curr;
            TreeNode temp = curr;
            curr = curr.left;
            temp.left = null;
        }
    }
    return res;
}

```

### 4. 颜色标记法

1.使用颜色标记节点的状态，新节点标记为白色，已访问的节点标记为灰色。

2.如果遇到的节点为白色，则将其标记为灰色，然后将其右子节点、自身、左子节点依次入栈。

3.如果遇到的节点是灰色，则将节点的值输出。


```java
class ColorNode {
    TreeNode node;
    String color;

    public ColorNode (TreeNode node, String color) {
        this.node = node;
        this.color = color;
    }
}
public List < Integer > inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<ColorNode> stack = new Stack<>();
        stack.push(new ColorNode(root, "white"));
        while (!stack.isEmpty()) {
            ColorNode temp = stack.pop();
            if (temp == null || temp.node == null) continue;
            switch (temp.color) {
                case "white":
                    stack.push(new ColorNode(temp.node.right, "white"));
                    stack.push(new ColorNode(temp.node, "gray"));
                    stack.push(new ColorNode(temp.node.left, "white"));
                    break;
                default:
                    res.add(temp.node.val);
                    break;
            }
        }
        return res;
    }

```



