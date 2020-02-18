//给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。 
//
// 你可以对一个单词进行如下三种操作： 
//
// 
// 插入一个字符 
// 删除一个字符 
// 替换一个字符 
// 
//
// 示例 1: 
//
// 输入: word1 = "horse", word2 = "ros"
//输出: 3
//解释: 
//horse -> rorse (将 'h' 替换为 'r')
//rorse -> rose (删除 'r')
//rose -> ros (删除 'e')
// 
//
// 示例 2: 
//
// 输入: word1 = "intention", word2 = "execution"
//输出: 5
//解释: 
//intention -> inention (删除 't')
//inention -> enention (将 'i' 替换为 'e')
//enention -> exention (将 'n' 替换为 'x')
//exention -> exection (将 'n' 替换为 'c')
//exection -> execution (插入 'u')
// 
// Related Topics 字符串 动态规划


package leetcode.editor.cn;

import java.util.Arrays;

public class EditDistance {
    public static void main(String[] args) {
        Solution solution = new EditDistance().new Solution();
        System.out.println(solution.minDistance("intention", "hxecution"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minDistance(String word1, String word2) {
            int n1 = word1.length();
            int n2 = word2.length();
            int[][] dp = new int[n1 + 1][n2 + 2];
            for (int i = 1; i <= n2; i++) {
                dp[0][i] = dp[0][i - 1] + 1;
            }
            for (int i = 1; i <= n1; i++) {
                dp[i][0] = dp[i - 1][0] + 1;
            }
            for (int i = 1; i <= n1; i++) {
                for (int j = 1; j <= n2; j++) {
                    for (int[] ints : dp) {
                        System.out.println(Arrays.toString(ints) + ",");
                    }
                    System.out.println("i:" + i + ",j:" + j);
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
                    }
                }
            }
            return dp[n1][n2];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}