学习笔记

哈希表、映射、集合

**HashTable**
哈希表（HashTable），也叫散列表，根据关键码值（key value）而直接进行访问的数据结构。
它通过把关键码值映射到表中一个位置来访问记录，以加快查找的 速度。 
这个映射函数叫作散列函数（Hash Function），存放记录的数组叫作哈希表（或散列表）。
**工程应用**
电话用户薄、用户信息表、LRU缓存、键值对存储（Redis）

**树、二叉树、二叉搜索树**
LinkedList是特殊化的Tree
Tree是特殊化的Graph
**二叉树遍历**
1.前序（Pre-order）：根-左-右
2.中序（In-order）：左-根-右
3.后序（Post-order）：左-右-根
def preorder(self, root):   if root:    self .traverse_path.append(root.val)    self .preorder(root.left)    self .preorder(root.right) def inorder(self, root):  if root:    self .inorder(root.left)    self .traverse_path.append(root.val)    self .inorder(root.right) def postorder(self, root):  if root:    self .postorder(root.left)    self .postorder(root.right)    self .traverse_path.append(root.val) 
**二叉搜索树（Binary Search Tree）**
二叉搜索树，也称二叉搜索树、有序二叉树（Ordered Binary Tree）、 排序二叉树（Sorted Binary Tree），是指一棵空树或者具有下列性质的 二叉树： 1. 左子树上所有结点的值均小于它的根结点的值； 2. 右子树上所有结点的值均大于它的根结点的值； 3. 以此类推：左、右子树也分别为二叉查找树。 （这就是 重复性！）
中序遍历：升序排列
树的面试题解法一般都是**递归**（Recusion）

**泛型递归、树的递归**
递归 - 循环
通过函数体来进行的循环
**代码模板**
public void recur(int level, int param) {   
		// terminator    
		if (level > MAX_LEVEL) {     
		// process result      
			return;    
		}    
		// process current logic    
		process(level, param);    
		// drill down    
		recur( level: level + 1, newParam);    
		// restore current status
}

**思维要点**
不要人肉进行递归（最大误区）
找到最近最简方法，将其拆解成可重复解决的问题（重复子问题）
数学归纳法思维

数学归纳法思维



数学归纳法思维

通过函数体来进行的循环

通过函数体来进行的循环


















