import java.util.Stack;

public class LeetCode_42_0082 {
	public int trap(int[] height) {
//		int result = 0;
//		for (int i = 1; i < height.length - 1; i++) {
//			int h = Math.min(maxHeight(height, 0, i - 1), maxHeight(height, i + 1, height.length - 1));
//			if (h - height[i] > 0) {
//				result += h - height[i];
//			}
//		}
//		return result;

		Stack<Integer> stack = new Stack<Integer>();
		int result = 0;
		for (int i = 0; i < height.length; i ++) {
			while (!stack.empty() && height[stack.peek()] < height[i]) {
				int index = stack.pop();
				if (stack.empty()) {
					break;
				}
				int dist = i - stack.peek() - 1;
				result += dist * (Math.min(height[stack.peek()], height[i]) - height[index]);
			}
			stack.push(i);
		}
		return result;
	}

	/**
	 * 给定数组左右边界后，查询这段里面的最大值
	 * @param height
	 * @param start
	 * @param end
	 * @return
	 */
	private int maxHeight(int[] height, int start, int end) {
		int max = 0;
		for (int i = start; i <= end; i++) {
			max = Math.max(height[i], max);
		}
		return max;
	}
}