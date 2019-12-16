// 国际站示例，把0移除，然后在数组后面补0
var moveZeroes = function(nums) {       
    for(var i = nums.length;i--;){
        if(nums[i]===0){
            nums.splice(i,1)
            nums.push(0);
        }
    }
};