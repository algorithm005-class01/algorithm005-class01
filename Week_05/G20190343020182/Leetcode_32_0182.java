package week005;

import java.util.Stack;

import org.junit.Test;


/*
给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。

示例 1:

输入: "(()"
输出: 2
解释: 最长有效括号子串为 "()"
示例 2:

输入: ")()())"
输出: 4
解释: 最长有效括号子串为 "()()"

 * */

public class Leetcode_32_0182 {
	
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') {
				stack.push(c);
			}
			else if (!stack.isEmpty()) {
					stack.pop();
		    }
			else {
				return false;
			}
		}		
		
		return stack.isEmpty();
	}
	
	public int longestValidParentheses3(String s) {
		int max = 0;
		for (int i = 0; i <= s.length(); i++) {
			for (int j = i + 2; j <= s.length(); j += 2) {
				if (isValid(s.substring(i, j))) {
					max = Math.max(max, j - i);
				}
			}
		}
		
		return max;
	}
	
	public int longestValidParentheses2(String s) {
		int max = 0;
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(-1);
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			}
			else {
				stack.pop();
				if (stack.isEmpty()) {
					stack.push(i);
				}
				else {
					max = Math.max(max, i - stack.peek());
				} 
			}
		}
		
		return max;
	}
	
	int longestValidParentheses(String s) {
		if (s.length() <= 1) {
			return 0;
		}
		int curMax = 0;
		int longest[] = new int[s.length()];
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == ')') {
				if (s.charAt(i) == '(') {
					longest[i] = (i - 2) >= 0 ? (longest[i - 2] + 2) : 2;
					curMax = Math.max(longest[i], curMax);
				} else {
					if (i - longest[i - 1] - 1 >= 0 && s.charAt(i - longest[i - 1] - 1) == '(') {
						longest[i] = longest[i - 1] + 2
								+ ((i - longest[i - 1] - 2 >= 0) ? longest[i - longest[i - 1] - 2] : 0);
						curMax = Math.max(longest[i], curMax);
					}
				}
			}
		}
		return curMax;
	}
	
	@Test
    public void test() {
		// System.out.println(longestValidParentheses(""));
		System.out.println(longestValidParentheses3("()"));
		System.out.println(longestValidParentheses3(")()())"));

	
		System.out.println(isValid(""));
		System.out.println(isValid("()"));
		System.out.println(isValid("())"));
		System.out.println(isValid("(())"));
		System.out.println(isValid("()()"));
		System.out.println(isValid("()(()"));
	}

}
