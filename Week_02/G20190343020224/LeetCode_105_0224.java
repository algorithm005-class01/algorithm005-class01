class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        LinkedList<Integer> preDeque = new LinkedList<>();
        for (int item : preorder) {
            preDeque.push(item);
        }
        List<Integer> inList = Arrays.stream(inorder).boxed().collect(Collectors.toList());
        return helper(0, inList.size(), preDeque, inList);
    }

    public TreeNode helper(int inStart, int inEnd, LinkedList<Integer> preDeque, List<Integer> inList) {
        if (inStart == inEnd) {
            return null;
        }
        Integer rootVal = preDeque.pollLast();
        Integer midIndex = inList.indexOf(rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.left = helper(inStart, midIndex, preDeque, inList);
        root.right = helper(midIndex + 1, inEnd, preDeque, inList);
        return root;
    }

}