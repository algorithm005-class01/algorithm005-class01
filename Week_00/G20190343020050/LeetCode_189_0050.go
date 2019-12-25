package main

func rotate(nums []int, k int)  {
	var last,id,i int
	var length = len(nums)
	for i=0;i<k;i++{
		last = nums[length-1]
		for id=length-1;id>0;id--{
			nums[id] = nums[id-1]
		}
		nums[0] = last
	}
}
