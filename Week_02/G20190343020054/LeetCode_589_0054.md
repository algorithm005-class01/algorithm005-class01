# 589. N叉树的前序遍历

> 给定一个 N 叉树，返回其节点值的前序遍历。
>
> 例如，给定一个 3叉树 :
> 
> ![](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/12/narytreeexample.png) 
> 
> 返回其后序遍历:[1,3,5,6,2,4]。
> 
> 说明: 递归法很简单，你可以使用迭代法完成此题吗?

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
    // 退出条件
    if (root == null) return;
    // 要做的事情
    res.add(node.val);
    // 跳到下一级
    for(Node n : node.children) {
      helper(n, res);
    }

    // 清除状态
    
   
}
```

### 2. 迭代

```java
public List<Integer> preorder(Node root) {
    List<Integer> res = new ArrayList<>();
    if (root == null) return res;
    Stack<Node> stack = new Stack<>();
    stack.push(root);
    while (!stack.isEmpty()) {
        Node cur = stack.pop();
        //头结点加入结果集
        res.add(cur.val);
        //将该节点的子节点从右往左压入栈
        List<Node> nodeList = cur.children;
        for (int i = nodeList.size() - 1; i >= 0; i--) {
            stack.push(nodeList.get(i));
        }
    }
    return res;
}
```