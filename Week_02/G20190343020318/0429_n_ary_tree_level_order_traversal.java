class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if (root == null) return res;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            List<Integer> currLevel = new LinkedList<>();
            int len = q.size();
            for (int i = 0; i < len; ++i) {
                Node curr = q.poll();
                currLevel.add(curr.val);
                for (Node n : curr.children)
                    q.offer(n);                    
            }
            res.add(currLevel);
        }
        return res;
    }
}