var removeDuplicates = function(nums) {
    if(nums == null && nums.length <0) return 0;
    let i = 0;
    let j = 1;
    while(j<nums.length){
        if(nums[i] !== nums[j]){
            nums[i+1] = nums[j];
            i++; 
        }
        j++; 
    }
    return i+1;
};