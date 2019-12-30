//1。层序遍历，效率太低
class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return travelsal(root, p, q);
    }

    public TreeNode travelsal(List<TreeNode> roots, TreeNode p, TreeNode q) {
        if (roots.isEmpty()) {
            return null;
        }
        TreeNode ancestorNode = null;
        for (TreeNode root : roots) {
            Boolean isPAncestor = checkAncestor(root, p);
            Boolean isQAncestor = checkAncestor(root, q);

            if (isPAncestor && isQAncestor) {
                ancestorNode = root;
                break;
            }
        }
        if (ancestorNode != null) {
            TreeNode lowAncestor = travelsal(Arrays.asList(ancestorNode.left, ancestorNode.right));
            if (lowAncestor != null) {
                ancestorNode = lowAncestor;
            }
        }
        return ancestorNode;
    }

    public Boolean checkAncestor(TreeNode root, TreeNode node) {
        if (root == null) {
            return false;
        }
        if (root == node) {
            return true;
        }
        Boolean checkLeft = checkAncestor(root.left, node);
        Boolean checkRight = checkAncestor(root.right, node);
        return checkLeft || checkRight;
    }

}
//2.官方题解
class Solution {

    public TreeNode lowestCommonAncester;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lowestCommonAncester = null;
        helper(root, p, q);
        return lowestCommonAncester;
    }

    public boolean helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        int left = helper(root.left, p, q) ? 1 : 0;
        int right = helper(root.right, p, q) ? 1 : 0;
        int mid = (root == p || root == q) ? 1 : 0;
        if (left + right + mid > 0) {
            if (left + right + mid > 1) {
                lowestCommonAncester = root;
            }
            return true;
        }
        return false;
    }

}