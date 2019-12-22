package com.kawo.algorithm.code.weekb.impl

import com.kawo.algorithm.code.weekb.agreement.WeekBHomeWorkAgreement
import com.kawo.algorithm.code.weekb.vo.NTNode
import com.kawo.algorithm.code.weekb.vo.TNode
import java.util.*
import java.util.Collections.emptyList


class WeekBHomeWork : WeekBHomeWorkAgreement{
    override fun isAnagram(s: String, t: String): Boolean {
        if (s.length !== t.length) {
            return false
        }
        val str1 = s.toCharArray()
        val str2 = t.toCharArray()
        Arrays.sort(str1)
        Arrays.sort(str2)
        return str1.contentEquals(str2)
    }

    override fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val hash = HashMap<String, MutableList<String>?>()
        for (i in strs.indices) {
            val num = IntArray(26)
            for (element in strs[i]) {
                num[element - 'a']++
            }
            var key = ""
            for (j in num.indices) {
                key = key + num[j] + '#'
            }
            if (hash.containsKey(key)) {
                hash[key]!!.add(strs[i])
            } else {
                val temp: MutableList<String> = ArrayList()
                temp.add(strs[i])
                hash[key] = temp
            }
        }
        return ArrayList<List<String>>(hash.values)
    }

    override fun inorderTraversal(root: TNode): List<Int> {
        val res: MutableList<Int> = ArrayList()
        val stack: Deque<TNode> = ArrayDeque()
        var p: TNode? = root
        while (!stack.isEmpty() || p != null) {
            while (p != null) {
                stack.push(p)
                p = p.left
            }
            val tmp = stack.pop()
            res.add(tmp.data)
            p = tmp.right
        }
        return res

    }

    override fun preorderTraversal(root: TNode): List<Int> {
        val stack: Deque<TNode> = LinkedList()
        var p: TNode? = root
        val res: MutableList<Int> = ArrayList()
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                res.add(p.data)
                stack.push(p)
                p = p.left
            }
            p = stack.pop().right
        }
        return res
    }

    override fun postorder(root: NTNode): List<Int> {
        val res: MutableList<Int> = ArrayList()
        var pre: NTNode? = null
        val stack: Stack<NTNode> = Stack()
        stack.push(root)
        while (!stack.isEmpty()) {
            val cur: NTNode = stack.peek()
            if (cur.children!!.isEmpty() || pre != null && cur.children!!.contains(pre)) { //加入结果集
                res.add(cur.data)
                stack.pop()
                pre = cur
            } else {
                val nodeList: List<NTNode> = cur.children!!
                for (i in nodeList.indices.reversed()) {
                    stack.push(nodeList[i])
                }
            }
        }
        return res
    }

    override fun preorder(root: NTNode): List<Int> {
        val res: MutableList<Int> = ArrayList()
        val stack: Stack<NTNode> = Stack<NTNode>()
        stack.push(root)
        while (!stack.isEmpty()) {
            val cur: NTNode = stack.pop()
            res.add(cur.data)
            val nodeList: List<NTNode> = cur.children!!
            for (i in nodeList.indices.reversed()) {
                stack.push(nodeList[i])
            }
        }
        return res
    }

    override fun levelOrder(root: NTNode): List<List<Int>> {
        val res: MutableList<List<Int>> = ArrayList()
        if (root == null) return res
        val queue: Queue<NTNode> = LinkedList<NTNode>()
        queue.add(root)
        while (!queue.isEmpty()) {
            var count: Int = queue.size
            val list: MutableList<Int> = ArrayList()
            while (count-- > 0) {
                val cur: NTNode = queue.poll()
                list.add(cur.data)
                for (node in cur.children!!) {
                    if (node != null) {
                        queue.add(node)
                    }
                }
            }
            res.add(list)
        }
        return res
    }

    override fun lowestCommonAncestor(root: TNode, p1: TNode, q1: TNode): TNode {
        var p = p1
        var q = q1
        val stack: Deque<TNode> = ArrayDeque()
        val parent: MutableMap<TNode, TNode?> = HashMap()
        parent[root] = null
        stack.push(root)
        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            val node = stack.pop()
            if (node.left != null) {
                parent[node.left!!] = node
                stack.push(node.left)
            }
            if (node.right != null) {
                parent[node.right!!] = node
                stack.push(node.right)
            }
        }
        val ancestors: MutableSet<TNode> = HashSet()
        while (p != null) {
            ancestors.add(p)
            p = parent.get(p)!!
        }
        while (!ancestors.contains(q)) q = parent.get(q)!!
        return q
    }

    override fun buildTree(preorder: Array<Int>, inorder: Array<Int>): TNode? {
        if (preorder.isEmpty()) {
            return null
        }
        val roots = Stack<TNode>()
        var pre = 0
        var `in` = 0
        var curRoot = TNode(preorder[pre])
        val root: TNode = curRoot
        roots.push(curRoot)
        pre++
        while (pre < preorder.size) {
            if (curRoot.data == inorder[`in`]) {
                while (!roots.isEmpty() && roots.peek().data == inorder[`in`]) {
                    curRoot = roots.peek()
                    roots.pop()
                    `in`++
                }
                curRoot.right = TNode(preorder[pre])
                curRoot = curRoot.right!!
                roots.push(curRoot)
                pre++
            } else {
                curRoot.left = TNode(preorder[pre])
                curRoot = curRoot.left!!
                roots.push(curRoot)
                pre++
            }
        }
        return root
    }

    override fun combine(n: Int, k: Int): List<List<Int>> {
        if (n == 0 || k == 0 || k > n) return emptyList()
        var res: MutableList<List<Int>> = ArrayList()
        for (i in 1..n + 1 - k) res.add(Arrays.asList(i))
        for (i in 2..k) {
            val tmp: MutableList<List<Int>> = ArrayList()
            for (list in res) {
                for (m in list[list.size - 1] + 1..n - (k - (i - 1)) + 1) {
                    val newList: MutableList<Int> = ArrayList(list)
                    newList.add(m)
                    tmp.add(newList)
                }
            }
            res = tmp
        }
        return res
    }

}