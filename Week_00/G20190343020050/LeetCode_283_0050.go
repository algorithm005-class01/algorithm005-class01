package main

func moveZeroes(nums []int)  {
	var id,id2,num,length int
	length = len(nums)
	for id=0;id<length;id++{
		num = nums[id]
		if num != 0 {
			continue
		}

		for id2 = id+1; id2<length; id2++{
			num = nums[id2]
			if num != 0 {
				nums[id],nums[id2] = nums[id2],nums[id]
				break
			}
		}
	}
}
