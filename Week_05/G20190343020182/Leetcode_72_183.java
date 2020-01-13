package week005;

import org.junit.Test;

/*
给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。

你可以对一个单词进行如下三种操作：

插入一个字符
删除一个字符
替换一个字符
示例 1:

输入: word1 = "horse", word2 = "ros"
输出: 3
解释: 
horse -> rorse (将 'h' 替换为 'r')
rorse -> rose (删除 'r')
rose -> ros (删除 'e')
示例 2:

输入: word1 = "intention", word2 = "execution"
输出: 5
解释: 
intention -> inention (删除 't')
inention -> enention (将 'i' 替换为 'e')
enention -> exention (将 'n' 替换为 'x')
exention -> exection (将 'n' 替换为 'c')
exection -> execution (插入 'u')
 * */
public class Leetcode_72_183 {
    // 子问题
    // problem = subproblemA + subproblemB
    // 状态定义
    // dp[i][j] 表示i,j 表示word1 和 word2 最小编辑距离
    // dp 方程
    // word1.chatAt(i - 1) == word2.chatAt(j - 1) dp[i][j] = dp[i - 1][j - 1]
	// word1.chatAt(i - 1) != word2.chatAt(j - 1) dp[i][j] = min(dp[i - 1][j - 1], dp[i][j - 1], dp[i - 1][j]) + 1;

    
    public int minDistance(String word1, String word2) {
        if (word1 == null || word1.equals("")) {
        	return word2 == null ? 0 : word2.length();
        }
    	
        if (word2 == null  || word2.equals("")) {
        	return word1.length();
        }
        
        int m = word1.length();
        int n = word2.length();
        int dp[][] = new int[m + 1][n + 1];
        
        for (int i = 0; i <= n; i++) {
        	dp[0][i] = i;
        }
        
        for (int i = 0; i <= m; i++) {
        	dp[i][0] = i;
        }
        
        for (int i = 1; i <= m; i++) {
        	for (int j = 1; j <= n; j++) {
        		if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
        			dp[i][j] = dp[i - 1][j - 1];
        		}
        		else {
        			dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
        		}	
        	}
        }
        
		return dp[m][n];
    }
    
    @Test
    public void test()
    {
    	System.out.println(minDistance("", ""));    
    	System.out.println(minDistance("a", "a")); 
    	System.out.println(minDistance("a", "ab")); 
    	System.out.println(minDistance("horse", "ros"));    
    	System.out.println(minDistance("intention", "execution")); 
    }
}
