### 学习笔记

#### rotated-sorted-array中寻找无序位置

使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方

- 题目的意思
    > 题目给的例子中，7和0之间出现无序，假设我们返回出现无序时的前一个元素下标，也就是7的下标3。如果数组完全有序，输出-1。
- 所有解法
    > 顺序遍历

    > 二分查找
- 二分查找代码
```java
public class Main {
	public void unsortedIndex(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			if (nums[left] < nums[right]) {
				return left - 1;
			}
			int mid = left + (right - left) / 2;
			if (nums[left] < nums[mid]) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return nums.size() == 0 ? right : left;
	}
}
```
- 测试用例
    > 题目给出用例
    >
    >[4, 5, 6, 7, 0, 1, 2]  -> 3
    
    > 常规用例
    >
    >[0, 2, 4, 6, 8] -> -1
    >
    >[6, 7, 8, 2] -> 2
    >
    >[6, 7, 8, 2, 3] -> 2
    >
    >[9, 1, 2, 3, 4, 5, 6, 7, 8] -> 0
    
    > 特殊用例
    >
    >[] -> -1