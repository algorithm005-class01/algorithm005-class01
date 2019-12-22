// 解法一：遍历取非0值 && push 0
// 遍历数组，非0的元素移动数组前方，用index下标记录。
// 遍历结束，对index值后的元素统一设为0
var moveZeroes = function(nums) {
	var insertZero = 0;
	var n = nums.length;
	for(var i = 0; i < n; i++){
		if(nums[i] != 0){
			nums[insertZero++] = nums[i]
		}
	}
	while(insertZero < n){
		nums[insertZero++] = 0;
	}
}