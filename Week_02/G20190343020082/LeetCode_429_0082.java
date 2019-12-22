public class LeetCode_429_0082 {
	public List<List<Integer>> levelOrder(Node root) {
		List<List<Integer>> results = new ArrayList<>();
		LinkedList<Node> queue = new LinkedList<>();
		if (root != null) {
			queue.add(root);
		}
		while (!queue.isEmpty()) {
			int count = queue.size();
			List<Integer> result = new ArrayList<>();
			for (;count > 0; count --) {
				Node node = queue.remove();
				result.add(node.val);
				queue.addAll(node.children);
			}
			results.add(result);
		}
		return results;
	}
}