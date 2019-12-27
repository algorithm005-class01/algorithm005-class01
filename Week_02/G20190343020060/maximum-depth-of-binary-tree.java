maximum-depth-of-binary-tree(二叉树最大深度)
//递归,时间复杂度O(n)
//迭代：1、BFS层次遍历 2、DFS前序遍历
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        //     int left_height = maxDepth(root.left);
        //     int right_height = maxDepth(root.right);
        //     return java.lang.Math.max(left_height, right_height) + 1;
      
        
        // LinkedList<TreeNode> queue = new LinkedList<>();
        // queue.add(root);
        // int maxDepth = 0;
        // while(!queue.isEmpty()){
        // 	maxDepth++;
        // 	int levelSize = queue.size();
        // 	for (int i = 0; i<levelSize.length; i++) {
        // 		TreeNode node = queue.pollFirst();
        // 		if(node.left!=null){
        // 			queue.add(node.left);
        // 		}
        // 		if(node.right!=null){
        // 			queue.add(node.right)
        // 		}

        // 	} 

        // }


        LinkedList<pair<TreeNode,Integer>> stack = new LinkedList<>();
        Stack.push(new Pair<>(root,1));
        int maxDepth = 0;
        while(!stack.isEmpty()){
        	Pair<TreeNode,Integer> pair = stack.pop;
        	TreeNode node = pair.first;
        	maxDepth = Math.max(maxDepth,pair.second);
        	int curDepth=pair.second;
        	if(node.left!=null){
        		stack.push(new Pair<node.left,curDepth+1>);
        	}
        	if(node.right!=null){
        		stack.push(new Pair<node.right,curDepth+1>);
        	}

        }
        rerurn maxDepth;
    }
}