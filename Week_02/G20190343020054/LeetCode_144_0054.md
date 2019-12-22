# 144. 二叉树的前序遍历

> 给定一个二叉树，返回它的 前序 遍历。
> 
> 示例:
> 
> 
> 输入: [1,null,2,3]  
>    1
>     \
>      2
>     /
>    3 
> 
> 
> 输出: [1,2,3]
> 
> 进阶: 递归算法很简单，你可以通过迭代算法完成吗？


## 解题思路

### 1. 递归

像之前的中序遍历类似。

首先添加，递归左子树，再递归右子树。

```java
public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    helper(root, res);
    return res;
}

private void helper(TreeNode root, List<Integer> res) {
    if (root != null) {
        res.add(root.val);
        if (root.left != null) {
            helper(root.left, res);
        }
        if (root.right != null) {
            helper(root.right, res);
        }
    }
}
```

### 2. 基于栈的遍历

```java
public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    TreeNode curr = root;
    // while (curr != null || !stack.isEmpty()) {
    //     while (curr != null) {
    //     	res.add(curr.val);
    //         stack.push(curr);
    //         curr = curr.left;
    //     }
    //     curr = stack.pop().right;
    // }

    while (curr != null) {
    	res.add(curr.val);
    	if (curr.right != null) {
    		stack.push(curr.right);
    	}
    	curr = curr.left;
    	if (node == null && !stack.isEmpty()) {
    		node = stack.pop();
    	}
    }

    return res;
}
```


### 3. 颜色标记法

1.使用颜色标记节点的状态，新节点标记为白色，已访问的节点标记为灰色。

2.如果遇到的节点为白色，则将其标记为灰色，然后将其右子节点、左子节点、自身依次入栈。

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
                    stack.push(new ColorNode(temp.node.left, "white"));
                    stack.push(new ColorNode(temp.node, "gray"));
                    break;
                default:
                    res.add(temp.node.val);
                    break;
            }
        }
        return res;
    }

```