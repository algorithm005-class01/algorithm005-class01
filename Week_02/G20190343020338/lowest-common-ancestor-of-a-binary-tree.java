import javax.swing.tree.TreeNode;
/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
*/
class Solution {
    static public static void main(String[] args) {

        private TreeNode ans;
    
        public Solution () {
            //变量来存储树节点。
            this.ans = null;
        }
    
        private boolean recureseTree (TreeNode currentNode, TreeNode p, TreeNode q) {
    
            //如果到达当前子树末尾，返回 false。
            if (currentNode == null) {
                return false;
            }
            //左子树递归
            int left = this.recureseTree(currentNode.left, p, q) ? 1 : 0;
            //右子树递归
            int right = this.recureseTree(currentNode.right, p, q) ? 1 : 0;
            //如果根节点是p或q其中的一个
            int mid = (currentNode == p || currentNode == q) ? 1 : 0;
            //如果左边、右边或中间的任意两个标志变为 True
            if (mid + left + right >= 2) {
                this.ans = currentNode;
            }
            //如果根节点、左子树、右子树中的任何一个为 True 则返回True
            return (mid + left + right > 0);
        }

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            // 遍历树
            TreeNode root = [3,5,1,6,2,0,8,null,null,7,4];
            this.recurseTree(root, 5, 1);
            return this.ans;
        }

    }
}
