public class LeetCode_51_0082 {
	public List<List<String>> solveNQueens(int n) {
		Set<Integer> column = new HashSet<>();
		Set<Integer> pie = new HashSet<>();
		Set<Integer> na = new HashSet<>();
		List<List<String>> results = new ArrayList<>();
		List<Integer> queen = new ArrayList<>();
		dfs(n, 0, column, pie, na, results, queen);
		return results;
	}

	private void dfs(int n, int level, Set<Integer> column, Set<Integer> pie, Set<Integer> na, List<List<String>> results, List<Integer> pos) {
		if (level == n) {
			List<String> result = new ArrayList<>();
			for (int i = 0; i < n; i ++) {
				String s = "";
				for (int j = 0; j < n; j ++) {
					if (j == pos.get(i)) {
						s += "Q";
					} else s += ".";
				}
				result.add(s);
			}
			results.add(result);
			return;
		}

		for (int i = 0; i < n; i ++) {
			if (column.contains(i)) continue;
			if (pie.contains(i + level)) continue;
			if (na.contains(i - level)) continue;
			column.add(i);
			pie.add(i + level);
			na.add(i - level);
			pos.add(i);
			dfs(n, level + 1, column, pie, na, results, pos);
			column.remove(i);
			pie.remove(i + level);
			na.remove(i - level);
			pos.remove(level);
		}
	}
}