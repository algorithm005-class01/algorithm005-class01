import com.geek.sf.tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Leecode_236_0116 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //临界条件
        if(root == null || root == p || root == q){ return root;}

        //下沉
        TreeNode leftTreeNode = lowestCommonAncestor(root.left,p,q);
        TreeNode rightTreeNode = lowestCommonAncestor(root.right,p,q);

        //process

        return leftTreeNode == null? rightTreeNode : rightTreeNode == null ? leftTreeNode : root;

    }
}