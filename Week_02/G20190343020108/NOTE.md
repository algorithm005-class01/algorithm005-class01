# 第二周学习总结

## 分析 HashMap

### 1. 初始大小

HashMap 默认的初始大小是16，当然这个默认值是可以设置的。如果事先知道大概数据量有多大，可以通过修改默认初始大小，减少动态扩容的次数，这样会大大提高 HashMap 的性能。

HashMap 数组长度必须是 2 的整次幂，因为（数组长度 - 1）相当于一个**低位掩码**，进行与操作的结果就是散列值的高位全部归零，只保留低位值，用来做数组的下标访问。

比如初始长度16，16 - 1 = 15，2进制表示为 `00000000 00000000 00000000 00001111`。“与”操作的结果就是截取了最低的四位，相当于取模操作。

### 2. 装载因子和动态扩容

最大装载因子默认是 0.75，当 HashMap 中元素个数超过 0.75 * capacity 的时候，就会启动扩容，每次扩容都会扩容为原来两倍大小。

### 3. 散列冲突解决办法

HashMap 底层采用链表法来解决冲突。

在 JDK 1.8 中，**当链表长度太长（默认超过8）时，链表就转换为红黑树**，可以利用红黑树快速增删改查的特点，提高 HashMap 的性能。当红黑树结点个数少于8个的时候，又会将红黑树转化为链表。（在数据量较小的情况下，红黑树要维护平衡，比起链表来，性能上的优势并不明显）

### 4. 散列函数

散列函数设计最求的是简单高效、分布均匀。

```java
// 源码
static final int hash(Object key) {
    int h;
    return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
}

int hash(Object key) {
    int h = key.hashCode()；
    return (h ^ (h >>> 16)) & (capicity -1); //capicity 表示散列表的大小
}
```

`hashCode()` 返回的是 Java 对象的 hash code。本身是个32位整型值，在系统中，这个值对于不同的对象必须保证唯一（Java规范，重写 equals 必须重写 hashcode 的原因）。

获取对象的 hashcode 之后，先进行位移运算（将高16位移动到低16位），然后再和自己做异或运算，这样计算出来的整型值具有高位和低位的性质。

最后，进行位于运算，计算数组中的位置。

因为 `A % B = A & (B - 1)`，所以， (h ^ (h >>> 16)) & (capacity - 1) = (h ^ (h >>> 16)) % capacity，也就是**除留余数法**。

## 递归

递归是一种解决问题的有效方法，在递归过程中，函数将自身作为子例程调用。每当递归函数调用自身时，它都会将给定的问题拆解为子问题。递归调用继续进行，直到到子问题无需进一步递归就可以解决的地步。

为了确保递归函数不会导致无限循环，它应具有以下属性：

- 一个简单的基本案例（basic case）（或一些案例） —— 能够不使用递归来产生答案的终止方案。
- 一组规则，也称作递推关系（recurrence relation），可将所有其他情况拆分到基本案例。

**实现递归函数**需要关注

- 递推关系：也就是问题的结果与子结果之间的关系，从而根据递推关系调用函数自身
- 基本情况：不需要递归调用就可以直接算出的情形

比如，爬楼梯问题中的前一级，前两级台阶的关系。

### 递归代码模板

常见的递归代码模板：

- 递归终止条件（需要先写上递归终止条件，忘记的话可能会造成无限递归）
- 处理当前层的逻辑代码
- 下探到下一层
- 清理当前层（比如一些全局变量）

### Python

```python
def recursion(level, param1, param2, ...):
  # recursion terminator
  if level > MAX_LEVEL:
    process_result
    return
  
  # process logic in current level
  process(level, data, ...)
  
  # drill down
  self.recursion(level + 1, p1, p2, ...)
  
  # reverse the current level status if needed
```

### Java

```java
public void recur(int level, int param) {
  // terminator
  if (level > MAX_LEVEL) {
    // process result
    return;
  }
  
  // process current logic
  process(level, param);

  // drill down
  process(level: level + 1, newParam);
  
  // restore current status
}
```

### 递归的思维要点

#### 1. 不要人肉进行递归（最大误区）

熟练之后，需要摈弃画递归状态树这种做法。

**直接看函数本身，写逻辑即可**。

#### 2. 找到最近最简方法，将其拆分成可重复解决的问题（重复子问题）

计算机本身只能处理类似 if else for loop while loop recusion 之类的简单语句，最后的复杂问题都可以用相对简单的代码来实现，正是因为子问题本身是具有重复性的。

#### 3. 数学归纳法思维

最简单的情况下，结论成立，比如(n = 1, n = 2)

同时，在条件为 n 结论成立时，可以推导出 n + 1 的时候结论也成立。（类似放鞭炮：前一个炮仗响了，后一个炮仗也会响）。

## 树、二叉树、N叉树相关

一般树的遍历操作可以通过两种方法：递归、迭代法。其中迭代法是利用栈来模拟递归的调用。在迭代法的基础上，会有一些不同的写法。这里以二叉树的先序遍历为例：

### 思路一：递归法（深度优先）

遍历顺序是从上到下，从左到右。

```js
/**
 * 解法一：递归法
 * @param {TreeNode} root
 * @return {number[]}
 */
var preorderTraversal = function(root) {
    const res = [];
    traversalPreorder(root, res);
    return res;
};

/**
 * @param {TreeNode} root
 * @param {number[]} res
 */
const traversalPreorder = (root, res) => {
    if (root) res.push(root.val);
    if (root && root.left) traversalPreorder(root.left, res);
    if (root && root.right) traversalPreorder(root.right, res);
};
```

时间复杂度：O(N) N 为 二叉树节点个数
空间复杂度：O(logN)，最坏情况下为O(N)

### 思路二：使用栈模拟递归（迭代法）

从根节点开始，每次迭代弹出当前栈顶元素，并将孩子节点按照**先右孩子节点**再**左孩子节点**压入栈中。

最后的结果按照 Top -> Bottom, Left -> Right 的顺序打印，符合前序输出。

```js
/**
 * 解法二：使用栈来模拟递归（迭代法）
 * @param {TreeNode} root
 * @return {number[]}
 */
var preorderTraversal2 = function(root) {
    if (!root) return [];
    const res = [];
    const stack = [root];
    let current;
    while (stack.length) {
        current = stack.pop();
        if (current) res.push(current.val);
        if (current && current.right) stack.push(current.right);
        if (current && current.left) stack.push(current.left);
    }
    return res;
};
```

时间复杂度：O(N) N 为节点个数
空间复杂度：O(N) 最坏的情况下存储整棵树

另一种写法：

访问根节点后，然后访问其左子树；当左子树遍历完成之后，需要访问右子树，这个时候就需要拿到父节点的信息。
通过父节点从而访问右子树，这样整棵树遍历完成之后，继续回退到上一层。直至当前子树访问完成，同时栈为空。

核心思想为：

1. 每拿到一个 节点 就把它保存在 栈 中

2. 继续对这个节点的 左子树 重复 过程1，直到左子树为 空

3. 因为保存在 栈 中的节点都遍历了 左子树 但是没有遍历 右子树，所以对栈中节点 出栈 并对它的 右子树 重复 过程1

4. 直到遍历完所有节点.

```js
/**
 * 另一种写法
 * 解法二：使用栈来模拟递归（迭代法）
 * @param {TreeNode} root
 * @return {number[]}
 */
var preorderTraversal3 = function(root) {
    if (!root) return [];
    const res = [];
    const stack = [];
    let current = root;
    while (current || stack.length) {
        while (current) {
            // 若当前节点非空
            res.push(current.val);
            stack.push(current);
            current = current.left; // 进入左子树
        }
        current = stack.pop();
        if (current) current = current.right; // 进入右子树
    }
    return res;
};
```

### 思路三：使用带有颜色标记的栈模拟递归（迭代法）

- 通过颜色来标记节点：白色代表未访问的节点，灰色代表已访问过的节点。

- 如果访问到的节点是白色，则将当前访问的节点标记为灰色，同时将节点的右孩子节点、左孩子节点、节点自身压入栈中。

- 如果访问到的节点是灰色，则输出该节点

```js

/**
 * 解法三：使用颜色标记位来模拟递归 （迭代法）
 * @param {TreeNode} root
 * @return {number[]}
 */
var preorderTraversal4 = function(root) {
    if (!root) return [];
    const [WHITE, GRAY] = [0, 1]; // WHITE - 未处理， GRAY - 已处理
    const stack = [[WHITE, root]]; // 初始状态： 根节点 未访问
    const res = [];
    let color, current;
    while (stack.length) {
        [color, current] = stack.pop();
        if (!current) continue;
        if (color === WHITE) {
            stack.push([WHITE, current.right]);
            stack.push([WHITE, current.left]);
            stack.push([GRAY, current]);
        } else res.push(current.val);
    }
    return res;
};
```

时间复杂度：O(N) N 为二叉树节点的个数
空间复杂度：O(N) 需要用到栈来存储节点，最坏情况下要存储整棵树

### 思路四：莫里斯遍历

遍历二叉树时，最大的难点在于，遍历到子节点的时候怎样重新返回到父节点（假设节点中没有指向父节点的p指针），由于不能用栈作为辅助空间。为了解决这个问题，Morris方法用到了线索二叉树（threaded binary tree）的概念。在Morris方法中不需要为每个节点额外分配指针指向其前驱（predecessor）和后继节点（successor），只需要利用叶子节点中的左右空指针指向某种顺序遍历下的前驱节点或后继节点就可以了。

```java
class Solution {
  public List<Integer> preorderTraversal(TreeNode root) {
    LinkedList<Integer> output = new LinkedList<>();

    TreeNode node = root;
    while (node != null) {
      if (node.left == null) {
        output.add(node.val);
        node = node.right;
      }
      else {
        TreeNode predecessor = node.left;
        while ((predecessor.right != null) && (predecessor.right != node)) {
          predecessor = predecessor.right;
        }

        if (predecessor.right == null) {
          output.add(node.val);
          predecessor.right = node;
          node = node.left;
        }
        else{
          predecessor.right = null;
          node = node.right;
        }
      }
    }
    return output;
  }
}
```
