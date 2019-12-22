public class LeetCode_589_0082 {
	public List<Integer> preorder(Node root) {
		List<Integer> list = new ArrayList<>();
		Stack<Node> stack = new Stack<>();
		if (root != null) {
			stack.push(root);
		}
		while (!stack.isEmpty()) {
			Node node = stack.pop();
			list.add(node.val);
			Collections.reverse(node.children);
			for (Node child : node.children) {
				stack.push((child));
			}
		}
		return list;
	}
}