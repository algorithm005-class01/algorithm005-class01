package week006;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import org.junit.Test;

/*
给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。

示例 1:

输入:
11110
11010
11000
00000

输出: 1
示例 2:

输入:
11000
11000
00100
00011

输出: 3
 * */
public class Leetcode_200_182 {

	// dfs
    public int numIslands3(char[][] grid) { 
    	if (grid == null || grid.length == 0) {
    		return 0;
    	}
    	
    	int r = grid.length;
    	int c = grid[0].length;
    	int numOfIsland = 0;
    	for (int i = 0; i < r; i++) {
    		for (int j = 0; j < c; j++) {
    			if (grid[i][j] == '1') {
    				numOfIsland++;
    				dfs(grid, i, j);
    			}
    		}
    	}
    	
    	return numOfIsland;
    }
    
    private void dfs(char[][] grid, int r, int c) {
    	int rc = grid.length;
    	int cc = grid[0].length;
    	if (r < 0 || c < 0 || r == rc || c == cc || grid[r][c] == '0') {
    		return;
    	}
    	
    	grid[r][c] = '0';
    	dfs(grid, r + 1, c);
    	dfs(grid, r - 1, c);
    	dfs(grid, r, c + 1);
    	dfs(grid, r, c - 1);    	
    }
    
	// dfs stack
    public int numIslands4(char[][] grid) { 
    	if (grid == null || grid.length == 0) {
    		return 0;
    	}
    	
    	int r = grid.length;
    	int c = grid[0].length;
    	int numOfIsland = 0;
    	for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (grid[i][j] == '1') {
					numOfIsland++;
			    	Stack<Integer> s = new Stack<Integer>();
			    	s.push(i * c + j);
					grid[i][j] = '0';  // mark as visited
					while (!s.isEmpty()) {
						int num = s.pop();
						int tmpR = num / c;
						int tmpC = num % c;
						if (tmpR >= 1 && grid[tmpR - 1][tmpC] == '1') {
							grid[tmpR - 1][tmpC] = '0';
							s.push((tmpR - 1) * c  + tmpC);
						}
						if (tmpR + 1 < r  && grid[tmpR + 1][tmpC] == '1') {
							grid[tmpR + 1][tmpC] = '0';
							s.push((tmpR + 1) * c  + tmpC);
						}
						if (tmpC >= 1  && grid[tmpR][tmpC - 1] == '1') {
							grid[tmpR][tmpC - 1] = '0';
							s.push(tmpR * c  + tmpC - 1);
						}
						if (tmpC + 1 < c && grid[tmpR][tmpC + 1] == '1') {
							grid[tmpR][tmpC + 1] = '0';
							s.push(tmpR * c  + tmpC + 1);
						}
					}
				}
			}
		}
    	
    	return numOfIsland;
    }
    
	// bfs
    public int numIslands2(char[][] grid) {
    	if (grid == null || grid.length == 0) {
    		return 0;
    	}
    	
    	int r = grid.length;
    	int c = grid[0].length;
    	int numOfIsland = 0;
    	for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (grid[i][j] == '1') {
					numOfIsland++;
			    	Queue<Integer> q = new LinkedList<Integer>();
			    	q.add(i * c + j);
					grid[i][j] = '0';  // mark as visited
					while (!q.isEmpty()) {
						int num = q.remove();
						int tmpR = num / c;
						int tmpC = num % c;
						if (tmpR >= 1 && grid[tmpR - 1][tmpC] == '1') {
							grid[tmpR - 1][tmpC] = '0';
							q.add((tmpR - 1) * c  + tmpC);
						}
						if (tmpR + 1 < r  && grid[tmpR + 1][tmpC] == '1') {
							grid[tmpR + 1][tmpC] = '0';
							q.add((tmpR + 1) * c  + tmpC);
						}
						if (tmpC >= 1  && grid[tmpR][tmpC - 1] == '1') {
							grid[tmpR][tmpC - 1] = '0';
							q.add(tmpR * c  + tmpC - 1);
						}
						if (tmpC + 1 < c && grid[tmpR][tmpC + 1] == '1') {
							grid[tmpR][tmpC + 1] = '0';
							q.add(tmpR * c  + tmpC + 1);
						}
					}
				}
			}
		}
    	
    	return numOfIsland;
    }
    
	class UnionFind {
		private int count = 0;
		private int[] parent;

		public UnionFind(int n) {
			count = n;
			parent = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = i;
			}
		}

		public UnionFind(char [][] grid) {
	    	int r = grid.length;
	    	int c = grid[0].length;
	    	parent = new int [r * c + c];
	    	for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (grid[i][j] == '1') {
					    parent[i * c + j] = i * c + j;
					    count++;
					}
				}
	    	}
		}
		
		public int find(int p) {
			while (p != parent[p]) {
				parent[p] = parent[parent[p]];
				p = parent[p];
			}
			return p;
		}

		public void union(int p, int q) {
			int rootP = find(p);
			int rootQ = find(q);
			if (rootP == rootQ)
				return;
			parent[rootP] = rootQ;
			count--;
		}
		
		public int getCount() {
			return count;
		}
	}

	// 并查集
    public int numIslands(char[][] grid) {
    	if (grid == null || grid.length == 0) {
    		return 0;
    	}
    	
    	int r = grid.length;
    	int c = grid[0].length;

    	UnionFind uf = new UnionFind(grid);
    	    	
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (grid[i][j] == '1') {
					grid[i][j] = '0';
					if (i > 0 && grid[i - 1][j] == '1') {
						uf.union(i * c + j, (i - 1) * c + j);
					}
					if (i + 1 < r && grid[i + 1][j] == '1') {
						uf.union(i * c + j, (i + 1) * c + j);
					}
					if (j > 0 && grid[i][j - 1] == '1') {
						uf.union(i * c + j, i * c + j - 1);
					}
					if (j + 1 < c && grid[i][j + 1] == '1') {
						uf.union(i * c + j, i * c + j + 1);
					}
				}
			}
		}
    	return uf.getCount();
    }
    
    @Test
    public void test()
    {
    	char[][] grid = new char[4][5];
    	int r = grid.length;
    	int c = grid[0].length;
    	for (int i = 0; i < r; i++) {
    		for (int j = 0; j < c; j++) {
    			grid[i][j] = '0';
    		}
    	}
    	grid[0][0] = '1';
    	grid[0][1] = '1';
    	grid[1][0] = '1';
    	grid[1][1] = '1';
    	grid[2][2] = '1';
    	grid[3][3] = '1';
    	grid[3][4] = '1';
    	// System.out.println(numIslands3(grid));    
    	System.out.println(numIslands(grid));  
    }
}
