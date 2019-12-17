var moveZeroes = function(nums) {
    let newIndex = 0;
    if(nums === null || nums.length === 0) return;
    for(let i = 0;i<nums.length;i++){
        if(nums[i] !==0){
            nums[newIndex++] = nums[i];
        }
    }
    for(let j = newIndex;j<nums.length;j++){
        nums[j] = 0;
    }
};