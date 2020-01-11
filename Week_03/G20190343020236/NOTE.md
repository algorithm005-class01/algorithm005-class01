学习笔记
1. 使用二分查找，寻找一个半有序数组[4, 5, 6, 7, 0, 1, 2]中间无序的地方：
   	此问题可以转换为找到最大值，最大值若为index，则满足：list[index] > list[index-1] 且 list[index] > list[index+1]，所以就可以用二分查找来搜索最大值，考虑两种情形来缩小查找范围：
   1. 若list[midpoint-1] < list[midpoint] 并且 list[midpoint] < list[midpoint+1]，说明midpoint此处是升序的，要找到最大值，只能在midpoint+1至high这一段来查找；
   2. 若list[midpoint-1] > list[midpoint] 并且 list[midpoint] > list[midpoint+1]，说明midpoint此处是降序的，要找到最大值，只能在low至midpoint-1这一段来查找。

