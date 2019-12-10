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

### https://leetcode-cn.com/problems/merge-sorted-array/

解题思路: 双指针方法

p1 数组1中非零的最后一个位置  p2 数组2中非零的最后一个位置. 因为num1[]数组的有足够的空间容纳nums2  p代表最后的位置

比较p1位置和p2位置元素的大小. 将大的元素放在p的位置上. 然后p--. 如果如果p2的大. p2-- 反之 p1--

当p1和p2都<0的时候. num1 就是有序的数组了. 

当两个数组都只有1个元素的时候. 那么nums1[]{0}. nums2[]{2} ,这种情况. 我们只需要将. nums2直接复制到num1里就可以了.

时间复杂度: O(n+m) n和m代表两个的长度. 
空间复杂度: O(1) 

