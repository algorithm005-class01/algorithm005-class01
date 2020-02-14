Bloom Filter vs Hash Table
1. 一个很长的二进制向量和一系列的随机映射函数 布隆过滤器可以用于检索一个元素是否存在一个集合中
2. 优点是 空间效率和查询时间都远远超过一般的算法
3. 缺点是 有一定的误识别率和删除困难

python 示例
```python
from bitarray import bitarray 
import mmh3 

class BloomFilter: 
	def __init__(self, size, hash_num): 
		self.size = size 
		self.hash_num = hash_num 
		self.bit_array = bitarray(size) 
		self.bit_array.setall(0) 

	def add(self, s): 
		for seed in range(self.hash_num): 
			result = mmh3.hash(s, seed) % self.size 
			self.bit_array[result] = 1 

	def lookup(self, s): 
		for seed in range(self.hash_num): 
			result = mmh3.hash(s, seed) % self.size 
			if self.bit_array[result] == 0: 
				return "Nope" 
		return "Probably" 
```


LRU Cache (Last Recent Used 最近最少使用)
1. 两个要素:  大小, 替换策略
2. HashTable + Double LinkedList
3. O(1) 查询时间复杂度
   O(1) 修改, 更新时间复杂度

LRUCache python 示例
```python
class LRUCache(object): 

	def __init__(self, capacity): 
		self.dic = collections.OrderedDict() 
		self.remain = capacity

	def get(self, key): 
		if key not in self.dic: 
			return -1 
		v = self.dic.pop(key) 
		self.dic[key] = v   # key as the newest one 
		return v 

	def put(self, key, value): 
		if key in self.dic: 
			self.dic.pop(key) 
		else: 
			if self.remain > 0: 
				self.remain -= 1 
			else:   # self.dic is full
				self.dic.popitem(last=False) 
		self.dic[key] = value
```

排序算法

1. 比较类排序:
通过比较来决定元素间的相对次序, 由于时间复杂度不能突破O(nlogn), 因此也称为非线性时间比较
排序.

2. 非比较类排序:
不通过比较来决定元素间的相对次序, 它可以突破基于比较排序的时间下届, 以线性时间运行, 因此也
称为线性时间非比较类排序.

|  排序算法 | 平均时间复杂度 | 最坏时间复杂度 | 最好时间复杂度 | 空间复杂度 | 稳定性 |
| ----- | ----- | ----- | ----- | ----- | ----- | ----- | ----- | ----- | 
| 简单插入排序  | O(n^2) |  O(n^2)   | O(n)  |  O(1)   | 稳定  |
| 希尔排序  | O() |  O()   | O()  |  O()   | O()  |
| 冒泡排序  | O(n^2) |  O(n^2)   | O(n)  |  O(1)   | 稳定  |
| 快速排序  | O() |  O()   | O()  |  O()   | O()  |
| 简单选择排序  | O(n^2) |  O(n^2)   | O(n^2)  |  O(1)   | 不稳定  |
| 堆排序  | O() |  O()   | O()  |  O()   | O()  |
| 二路归并排序  | O() |  O()   | O()  |  O()   | O()  |
| 多路归并排序  | O() |  O()   | O()  |  O()   | O()  |
| 计数排序  | O() |  O()   | O()  |  O()   | O()  |
| 桶排序  | O() |  O()   | O()  |  O()   | O()  |
| 基数排序  | O() |  O()   | O()  |  O()   | O()  |

初级排序 - O(n^2)
1. 选择排序(Selection Sort) 每次找到最小值, 然后放到待排序数组的起始位置.
```python
    def SelectionSort(self, nums: List[int]) -> List[int]:
        length = len(nums)
        for i in range(length):
            minIndex = i
            for j in range(i + 1, length):
                if nums[j] < nums[minIndex]:
                    minIndex = j
            temp = nums[i]
            nums[i] = nums[minIndex]
            nums[minIndex] = temp
        return nums
```

2. 插入排序(Insertion Sort) 从前到后逐步构建有序数列; 对于未排序数据, 在已排序序列中从后向前扫描,
找到相应位置插入.
```python
    def InsertionSort(self, nums: List[int]) -> List[int]:
        length = len(nums)
        for i in range(length):
            preIndex = i - 1
            cur = nums[i]
            while preIndex >= 0 and nums[preIndex] > cur:
                nums[preIndex + 1] = nums[preIndex]
                preIndex -= 1
            nums[preIndex + 1] = cur
        return nums
```

3. 冒泡排序(Bubble Sort) 嵌套循环, 每次查看相邻的元素如果逆序, 则交换. 与选择排序刚好相反, 每次循环
都可以将最大元素放置在数列最后的位置.
```python
    def BubbleSort(self, nums: List[int]) -> List[int]:
        length = len(nums)
        for i in range(length):
            for j in range(length - 1 - i):
                if nums[j] > nums[j + 1]:
                    temp = nums[j + 1]
                    nums[j + 1] = nums[j]
                    nums[j] = temp
        return nums
```

高级排序 - O(nlogn)
1. 快速排序(Quick Sort) 
数组取标杆pivot, 将小于pivot的元素放在pivot左边, 大于pivot的元素放在pivot的右边, 然后依次对左边和
右边的子数组进行快速排序, 以达到整个序列有序.

2. 归并排序(Merge Sort)
- 把长度为n的输入序列分成两个长度为n/2的子序列
- 对这两个子序列分别采用归并排序
- 将两个排序好的子序列合并成一个最终的排序序列

3. 堆排序(Heap Sort) 
堆插入 O(logn) 取最大/最小值 O(1)
- 数组元素依次建立小顶堆
- 依次取堆顶元素, 并删除