package com.kawo.algorithm.code.weekb.agreement

import com.kawo.algorithm.common.BaseExec

/**
 * 算法测试执行类
 * 第二周作业
 * 共13道题
 */
interface WeekBExecAgreement : BaseExec {
    /**
     * 242. 有效的字母异位词
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     * 示例 1:
     * 输入: s = "anagram", t = "nagaram"
     * 输出: true
     * 示例 2:
     * 输入: s = "rat", t = "car"
     * 输出: false
     * 说明:
     * 你可以假设字符串只包含小写字母。
     * 进阶:
     * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
     * LeetCode Link
     * https://leetcode-cn.com/problems/valid-anagram/description/
     */
    fun isAnagram()

    /**
     * 49. 字母异位词分组
     * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
     * 示例:
     * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
     * 输出:
     * [
     * ["ate","eat","tea"],
     * ["nat","tan"],
     * ["bat"]
     * ]
     * 说明：
     * 所有输入均为小写字母。
     * 不考虑答案输出的顺序。
     * LeetCode Link
     * https://leetcode-cn.com/problems/group-anagrams/
     */
    fun groupAnagrams()

    /**
     * 94. 二叉树的中序遍历
     * 给定一个二叉树，返回它的中序 遍历。
     * 示例:
     * 输入: [1,null,2,3]
     * 1
     *  \
     *   2
     *  /
     * 3
     * 输出: [1,3,2]
     * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
     * LeetCode Link
     * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
     */
    fun inorderTraversal()

    /**
     * 144. 二叉树的前序遍历
     * 给定一个二叉树，返回它的 前序 遍历。
     * 示例:
     * 输入: [1,null,2,3]
     * 1
     *  \
     *  2
     * /
     * 3
     * 输出: [1,2,3]
     * 进阶: 递归算法很简单，你可以通过迭代算法完成吗
     * LeetCode Link
     * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
     */
    fun preorderTraversal()


    /**
     * 590. N叉树的后序遍历
     * 给定一个 N 叉树，返回其节点值的后序遍历。
     * 例如，给定一个 3叉树 :
     * 返回其后序遍历: [5,6,3,2,4,1].
     * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
     * LeetCode Link
     * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
     */
    fun postorder()

    /**
     * 589. N叉树的前序遍历
     * 给定一个 N 叉树，返回其节点值的前序遍历。
     * 例如，给定一个 3叉树 :
     * 返回其前序遍历: [1,3,5,6,2,4]。
     * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
     * LeetCode Link
     * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/description/
     */
    fun preorder()

    /**
     * 429. N叉树的层序遍历
     * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
     * 例如，给定一个 3叉树 :
     * 返回其层序遍历:
     * [
     *[1],
     * [3,2,4],
     * [5,6]
     * ]
     * 说明:
     * 树的深度不会超过 1000。
     * 树的节点总数不会超过 5000。
     * LeetCode Link
     * https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
     */
    fun levelOrder()

    /**
     * 236. 二叉树的最近公共祖先
     * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
     * 示例 1:
     * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
     * 输出: 3
     * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
     * 示例 2:
     * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
     * 输出: 5
     * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
     * 说明:
     * 所有节点的值都是唯一的。
     * p、q 为不同节点且均存在于给定的二叉树中。
     * LeetCode Link
     * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
     */
    fun lowestCommonAncestor()

    /**
     * 105. 从前序与中序遍历序列构造二叉树
     * 根据一棵树的前序遍历与中序遍历构造二叉树。
     * 注意:
     * 你可以假设树中没有重复的元素。
     * 例如，给出
     * 前序遍历 preorder = [3,9,20,15,7
     * 中序遍历 inorder = [9,3,15,20,7]
     * 返回如下的二叉树：
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * LeetCode Link
     * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
     */
    fun buildTree()


    /**
     * 77. 组合
     * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
     * 示例:
     * 输入: n = 4, k = 2
     * 输出:
     * [
     * [2,4],
     * [3,4],
     * [2,3],
     * [1,2],
     * [1,3],
     * [1,4],
     * ]
     * LeetCode Link
     * https://leetcode-cn.com/problems/combinations/
     */
    fun combine()
}