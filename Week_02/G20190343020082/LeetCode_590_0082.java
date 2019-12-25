public class LeetCode_590_0082 {
	public List<Integer> postorder(Node root) {
		LinkedList<Integer> list = new LinkedList<>();
		Stack<Node> stack = new Stack<>();
		if (root != null) {
			stack.push(root);
		}
		while (!stack.isEmpty()) {
			Node node = stack.pop();
			list.addFirst(node.val);
			for (Node child : node.children) {
				stack.push(child);
			}
		}
		return list;
	}
}