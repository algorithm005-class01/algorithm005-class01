学习笔记
go语言

冒泡排序
func BubbleSort(a []int, n int) {
	if n <= 1 {
		return
	}
	for i := 0; i < n; i++ {
		// 提前退出标志
		flag := false
		for j := 0; j < n-i-1; j++ {
			if a[j] > a[j+1] {
				a[j], a[j+1] = a[j+1], a[j]
				//此次冒泡有数据交换
				flag = true
			}
		}
		// 如果没有交换数据，提前退出
		if !flag {
			break
		}
	}
}

插入排序
func InsertionSort(a []int, n int) {
	if n <= 1 {
		return
	}
	for i := 1; i < n; i++ {
		value := a[i]
		j := i - 1
		//查找要插入的位置并移动数据
		for ; j >= 0; j-- {
			if a[j] > value {
				a[j+1] = a[j]
			} else {
				break
			}
		}
		a[j+1] = value
	}
}

选择排序
func SelectionSort(a []int, n int) {
	if n <= 1 {
		return
	}
	for i := 0; i < n; i++ {
		// 查找最小值
		minIndex := i
		for j := i + 1; j < n; j++ {
			if a[j] < a[minIndex] {
				minIndex = j
			}
		}
		// 交换
		a[i], a[minIndex] = a[minIndex],a[i]

	}
}

快速排序
func QuickSort(nums []int,start,end int){
	if start >= end {
		return
	}

	mid := partition(nums,start,end)
	QuickSort(nums,start,mid)
	QuickSort(nums,mid+1,end)
}

func partition(nums []int,start,end int)  int{
	temp:= nums[start]
	low := start
	height := end

	for low < height{
		for low < height && temp < nums[height] {
			height--
		}
		if low < height {
			nums[low] = nums[height]
		}

		for low < height && temp > nums[low] {
			low++
		}

		if low < height {
			nums[height] = nums[low]
		}
	}

	nums[low] = temp

	return low
}

堆排序
func initHead(nums []int,parent,len int){
	temp := nums[parent]
	child := 2*parent+1

	for child < len {
		if child+1 < len && nums[child] < nums[child+1] {
			child++
		}

		if child < len && nums[child] <= temp {
			break
		}

		nums[parent] = nums[child]

		parent = child
		child = child*2+1
	}

	nums[parent] = temp
}

func HeadSort(nums []int){
	for i := len(nums)/2; i>=0; i-- {
		initHead(nums,i,len(nums))
	}

	for i := len(nums)-1;i >0; i--{
		nums[0],nums[i] = nums[i],nums[0]

		initHead(nums,0,i)
	}
}
