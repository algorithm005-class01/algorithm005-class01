学习笔记

## leetcode解题总结

### https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/

双指针解法:  慢指针i标识不重复元素的位置. j指针依次遍历. 

当i和j元素不相等时. i前进1. 并且将i和j的元素交互位置. 

时间复杂度: O(N)
空间复杂度: O(1)

### https://leetcode-cn.com/problems/rotate-array/

选择数组: 先将整个数组反转. 然后选择0到k-1的前半部分. 在旋转k到nums.length-1的后半部.

这样就得到了选择k个元素的目的.

时间复杂度: o(n) 因为最慢的0到nums.length-1次反转. 是O(n)
空间负责度: o(1)

### https://leetcode-cn.com/problems/merge-two-sorted-lists/

dump头结点解法: 设置一个dump节点. 动态的改变dump.next指针. 直到l1和l2遍历完成.


时间负责度: o(n+m) 因为每次迭代中都有一个node添加到dump链表中. while循环遍历完成l1和l2的总长度. 改变指针的操作是常数级别的. 所以是线性的
空间负责度: o(1) 是恒定不变的.