package com.kawo.algorithm.code.weekb.impl

import com.kawo.algorithm.code.weekb.agreement.WeekBExecAgreement
import com.kawo.algorithm.common.LOGGER
import com.kawo.algorithm.common.speed

class WeekBExec : WeekBExecAgreement{

    private val engine = WeekBHomeWork()

    override fun isAnagram() = speed {
        val s = "anagram"
        val t = "nagaram"
        LOGGER.info("242. 有效的字母异位词","输入：anagram nagaram 输出：${engine.isAnagram(s,t)}")
    }

    override fun groupAnagrams() = speed  {
        LOGGER.info("49. 字母异位词分组","输入 eat, tea, tan, te, na 输出 ${engine.groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat"))}")
    }

    override fun inorderTraversal() = speed {
        LOGGER.info(" 94. 二叉树的中序遍历","执行完毕")
    }

    override fun preorderTraversal() = speed {
        LOGGER.info("  144. 二叉树的前序遍历","执行完毕")
    }

    override fun postorder() = speed {
        LOGGER.info(" 590. N叉树的后序遍历","执行完毕")
    }

    override fun preorder() = speed {
        LOGGER.info(" 589. N叉树的前序遍历","执行完毕")
    }

    override fun levelOrder() = speed {
        LOGGER.info("  429. N叉树的层序遍历","执行完毕")
    }

    override fun lowestCommonAncestor() = speed {
        LOGGER.info("  236. 二叉树的最近公共祖先","执行完毕")
    }

    override fun buildTree() = speed {
        LOGGER.info("105. 从前序与中序遍历序列构造二叉树","执行完毕")
    }

    override fun combine() = speed {
        LOGGER.info(" 77. 组合","执行完毕")
    }

    override fun exec() {
        isAnagram()
        groupAnagrams()
        inorderTraversal()
        preorderTraversal()
        postorder()
        preorder()
        levelOrder()
        lowestCommonAncestor()
        buildTree()
        combine()
    }
}