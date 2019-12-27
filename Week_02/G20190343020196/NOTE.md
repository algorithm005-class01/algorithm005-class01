##	哈希表

### 哈希碰撞 

+ 哈希函数选得好，尽量的分散，减少碰撞， lookup:O(1)
+ 解决一个key, 映射多个value, 常用拉链式，升维加链表，lookup:O(n)
+ 最坏情况为O(n)，即退化成链表
  + value不分散
   + size太小， 都集中在一起

### 做题心态

+ 主要是key的选择，要尽量分散
+ 感觉key使用字符串 比 数学计算更好

## 树和递归

```python
//前
def preorder(self,root):
  if root:
    self.traverse_path.append(root.val)
    self.preorder(root.left)
    self.preorder(root.right)
 //中 
 def preorder(self,root):
  if root:
    self.inorder(root.left)
    self.traverse_path.append(root.val)
    self.inorder(root.right)
 //后 
 def postorder(self,root):
  if root:
    self.postorder(root.left)
    self.postorder(root.right)
    self.traverse_path.append(root.val)
```

```java
//利用前序遍历
class Solution {
        // 先序遍历--从顶向下交换
        public TreeNode invertTree(TreeNode root) {
            if (root == null) return null;
            // 保存右子树
            TreeNode rightTree = root.right;
            // 交换左右子树的位置
            root.right = invertTree(root.left);
            root.left = invertTree(rightTree);
            return root;
        }
    }

//利用中序遍历
class Solution1 {
    public TreeNode invertTree(TreeNode root) {
            if (root == null) return null;
            invertTree(root.left); // 递归找到左节点
            TreeNode rightNode= root.right; // 保存右节点
            root.right = root.left;
            root.left = rightNode;
            // 递归找到右节点 继续交换 : 因为此时左右节点已经交换了,所以此时的右节点为root.left
            invertTree(root.left); 
        	return root;
    }
}

//利用后序遍历
 class Solution2 {
        public TreeNode invertTree(TreeNode root) {
            // 后序遍历-- 从下向上交换
            if (root == null) return null;
            TreeNode leftNode = invertTree(root.left);
            TreeNode rightNode = invertTree(root.right);
            root.right = leftNode;
            root.left = rightNode;
            return root;
        }
    }

//利用层次遍历
   class Solution3 {
        public TreeNode invertTree(TreeNode root) {
            // 层次遍历--直接左右交换即可
            if (root == null) return null;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()){
                TreeNode node = queue.poll();
                TreeNode rightTree = node.right;
                node.right = node.left;
                node.left = rightTree;
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
            return root;
        }
    }
```



### 二叉搜索树

BST: 也叫OBT,SBT,有序，排序，指一颗空树或者具有下列性质的二叉树

+ left上所有结点的值均小于它的root。
+ right上所有的值均大于它的root.
+ 以此类推: 左，右子树也分别为二叉查找树（这就是重复性）

#### 中序遍历：升序排列 

+ 判读是否BST

### 常见操作

1. 查询 O(logN)
2. 插入新结点 O(logN) , 查询那个位置，没有就插入
3. 删除 O(logN)，查询这个位置，删除， 需要找个结点垫背
   + 两种方式
   + 可以找紧邻删掉的但小于删掉的节点
   + 也可以刚刚大于，即右子树的最小结点（一般用这种方式）



