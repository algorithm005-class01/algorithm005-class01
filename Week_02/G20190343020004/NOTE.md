#### 学习笔记
1. 哈希表，也叫散列表，根据关键码值进行数据访问
    * 可以类比数组，通过哈希计算所得的关键码类比于数组的下标。
    * 当产生哈希碰撞时，在关键码位置，通过链表顺延存储数据
    * 哈希公式设计的理想，查询的平均复杂度还是O(1)的；最坏情况，查询的复杂度是O(n)
2. 养成收藏记挂，比较好的解题思路、解题代码，收藏到笔记中，定期回顾。类似于我们的解题本或错题本
3. 简化理解，链表是特殊化的树(只有一边节点的树)，树是特殊的图(没有环的图)
4. 树节点的定义：
    ```
    public class TreeNode {
      public int val;
      public TreeNode left;
      public TreeNode right;
    
      public TreeNode(int val) {
          this.val = val;
          this.left = null;
          this.right = null;
      }
    }
    ```
5. 二叉树遍历
    * 前序(Pre-order)：根-左-右
    * 中序(In-order)：左-根-右
    * 后序(Post-order)：左-右-根
6. 可以认为递归和循环的效率差不多，递归要使用好缓存，避免重复操作
7. Java递归代码模板
    ```
    public void recursion(int level, int param) {
        //recursion terminator 递归终结条件
        if (level > MAX_LEVEL) {
            //process_result;
            return;
        }

        //process logic in current level 处理当前层逻辑
        process(level, param);

        //drill down 下探到下一层
        recursion(level + 1, param);

        //reverse the current level status if needed 清理当前层资源
    }
    ```
 8. 递归思维要点
    * 不要人肉进行递归
    * 找最近最简方法，将其拆解成可重复解决的问题(重复子问题)
    * 数学归纳法思维