// 解法二：双指针法
// 一个指针i用于遍历数组，另一个指针j用于指向0的位置，每次在需要交换的时候交换nums[i]和nums[j]的值然后令j++
// nums[i]和nums[j]都不为0的话就不交换只j++
// 简单理解就是利用双指针，遇到非零数就和0交换
/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var moveZeroes = function(nums) {
    // i用来遍历，j用来指向
    var i = 0,j = 0;
	for(;i<nums.length;i++){
        // 如果遍历的元素!=0
		if(nums[i] != 0){
            // j 和 i 不是同一个位置才交换
			if(j != i){
                // 将遍历的值赋给j指向的位置，将遍历的位置置成0
				nums[j] = nums[i];
				nums[i] = 0;
			}
			j++;
		}
	}
};