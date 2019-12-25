#莫里斯方法
class Solution(object):
    def preorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        node,output = root, []
        while node:
            if not node.left:                  #左子树为空
                output.append(node.val)        #加入当前根节点的值
                node = node.right              #移入右子树

            else:                              #左子树不为空
                pre = node.left                #前继结点设为 当前节点的左子树
                while pre.right and pre.right != None:  #前继节点的右子树 不为空 且 前继节点的右子树不为当前节点
                    pre = pre.right                     #寻找最右节点
                    
                if not pre.right:                    #最右节点为空,遍历结束
                    output.append(node.val)          #加入当前根节点的值
                    pre.right = node                 #建立连接，最右节点的右子树 为当前节点
                    
                else:                                #最右节点不为空，断开连接
                    pre.right = None                 #最右节点的右子树 为空
                    node = node.right                #当前节点的右子树 为当前节点

        return output

#解法2：递归
class Solution(object):
    def preorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        res = []
        if root:
            res.append(root.val)
            res += self.preorderTraversal(root.left)
            res += self.preorderTraversal(root.right)
        return res

#解法3 栈的方法，
class Solution(object):
    def preorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        res,stack =[],[root]
        while stack:                  #根节点不为空
            node = stack.pop()      

            if node:               
                res.append(node.val)            #res 先存入根节点
                stack.append(node.right)        #栈先压右孩子，再压左孩子，出栈就是左孩子先出，孩子后出
                stack.append(node.left)
        return res
            


