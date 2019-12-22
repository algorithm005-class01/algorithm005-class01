import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.sound.sampled.SourceDataLine;
import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        // return recursion(root);
        // return iteratorWithStack(root);
        return iteratorWithMorris(root);

    }


    /**
     * 方法三: 莫里斯遍历
     *      遍历树的时候往下找容易而往上翻难,所以需要递归和栈去记录上一个的路径,好翻回去.
     *      如果 中序遍历的时候能找到当前节点的左子树的最后一个遍历节点,并将它的右连接(即最后一个连接)指向根节点
     *      那么在遍历完左子树的时候无需往回翻,直接按照遍历规则继续走就行,莫里斯遍历的核心就是找前驱节点
     *      1.首先判断左子树是否为空,如果为空则证明没有左子树,遍历规则变为 根节点-->右节点 ,于是取当前的值,然后
     *      去遍历右子树
     *      2.左子树存在的情况下,要寻当前根节点的前驱节点,也就是其左子树的最后一个节点(即左子树的最右点),如果找到
     *      这个点,但这个点的右指针指向当前节点,则证明之前已经建立过链接了,并且整个左子树已经遍历完了,此时要恢复
     *      树的结构,并且取出根节点的值,此时根节点和左子树就完全遍历完了,将当前节点移至右子树的根节点,重新开始遍历
     *      3.如果找到最右的节点,那么将根节点左子树的最后一个遍历节点的右指针指向根节点,这样之后遍历完左子树就可以
     *      找回根节点了.移动当前节点到其左子树的根节点,继续寻找左子树根节点的前驱节点
     * 复杂度分析:
     *      时间: O(n)
     *      空间: O(1)
     * @param root
     * @return
     */
    public List<Integer> iteratorWithMorris(TreeNode root){
        List<Integer> res = new ArrayList<>();
        //寻找前置节点
        TreeNode pre = null;
        //当前节点
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                res.add(cur.val);
                cur = cur.right;
            }else{
                //寻找前驱节点
                pre = cur.left;
                while (pre.right!=null && pre.right != cur) {
                    pre = pre.right;
                }
                /**
                 * 前驱节点的右指针只有两种情况,要么指回了根节点,要么为null
                 */
                if (pre.right == cur) {
                    pre.right = null;
                    res.add(cur.val);
                    cur = cur.right;
                }else if (pre.right == null) {
                    pre.right = cur;
                    cur = cur.left;
                }
                
                
            }
        }
        return res;
    }

    /**
     * 方法二: 栈迭代法
     *      由于是中序便利,顺序为:左,中,右. 所以拿到一个树首先要看它有没有左子树,在其整个左子树都遍历完以后,我们还需要
     *      回到根节点上来,所以要把根节点放入栈中,栈里面放的就是按照等待遍历的节点.直到没有需要遍历的左子树了,就可以
     *      将栈中最上面的节点拿出来,将其值放入数组中,并按顺序遍历其右子树,右子树遍历同理,先看有没有左子树.....
     * 复杂度分析:
     *      时间: O(n)
     *      空间: O(n)
     * @param root
     * @return
     */
    public List<Integer> iteratorWithStack(TreeNode root){
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        //cur不为空需要看是否还有左子树没有遍历,stack不为空说明还是之前的节点没有遍历
        while (curr != null || !stack.isEmpty() ) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            //curr为null说明已经没有左子树了,需要将之前压入栈的根节点拿出来
            TreeNode tempNode = stack.pop();
            list.add(tempNode.val);
            //按照顺序该遍历右子树了
            curr = tempNode.right;
        }
        return list;
    }


    /**
     * 方法一: 递归法
     *      递归方法就是根据先判断左子树有没有遍历,如果没有就深入继续遍历
     * 复杂度分析:
     *      时间: O(n)
     *      空间: 最坏情况下需要空间O(n),平均情况为O(logn)。
     * @param root
     * @return
     */
    public List<Integer> recursion(TreeNode root){
        List<Integer> res = new ArrayList<>();
        recursionHelper(root, res);
        return res;
    }

    public void recursionHelper(TreeNode root, List < Integer > res){
        if (root != null) {
            if (root.left != null) {
                recursionHelper(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                recursionHelper(root.right, res);
            }
        }
    }
}
// @lc code=end

