学习笔记
# Tree

- 根结点、父结点、子结点、level、左右结点
- 和环的最大差别是看能否走回去。
- link list是特殊的tree，每个子结点只有一个。
- tree是特殊的graph。没有相连的graph

## 二叉树

子结点只有两个。

### 遍历

- 前序 pre-order: 根-左-右
- 中序 in-order: 左-根-右
- 后序 post-order:  左-右-根

##### 示例代码

前序

``````python
def preorder(self,root):
  if root:
    self.traveres_path.append(root.val)
    self.preorder(root.left)
    self.preorder(root.right)
``````

中序

``````python
def inorder(self,root)
if root:
  self.inorder(root,left)
  self.traverse_path.append(root.val)
  self.inorder(root.right)
``````

后续

``````python
def postorder(self,root):
  if root:
    self.postorder(root.left)
    self.postorder(root.right)
    self.traverse_path.append(root.val)
``````



## 二叉搜索树

- 左子树上所有结点的值均小于它的根结点的值
- 右子树上所有结点的值均大于它根节点的值
- 以此类推，左右树皆为二叉树
- 中序遍历，升序排列
- 插入和遍历都是logn
- 删除时，找到右子树中第一个比删除的节点大点的节点来垫背。

 ## 递归



# hashtable

- key通过hash函数获得下标，存入对应的位置
- 好的hash函数会让下标更分散，（减少碰撞几率？）

## hash碰撞

- hash值可能会冲突，叫hash碰撞。
- 简单的办法是将冲突下标向下移。
- 工程上的办法是再增加一个维度。拉链式解决冲突法，在冲突位置拉出一个链表，在size比较小、hash算法不好等极端情况下，会退化成链表，查询是On，一般认为是O1。

## 复杂度

- 查询、添加、删除 O(1)。

## 课后作业 解读hashmap.java

### put方法

- 先通过hash(k)方法计算hash值。
- 调整大小，resize方法调整并得到调整后的元素数组tab
- 如果tab的(n-1) &(位与) hash位没有元素，就放到这个位置。至于为啥是(n-1)&hash，就懵逼了。
- 如果这个位置有元素，判断两者hash是否相等且key是一样的，如果是，这替换value。
- 否则往p的next找空位插入元素。

### get方法

- 先找n-1 & hash找到位置上第一个node，如果key不匹配，就通过遍历node来查找。此时就查找就退化链表。