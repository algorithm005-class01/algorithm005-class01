var majorityElement = function(nums) {
    return majorityElementRec(nums, 0, nums.length - 1);
};

var majorityElementRec = function(nums, low, high) {
    if (low === high) {
        return nums[low];
    }
    
    let mid = Math.floor((low + high) / 2);
    let leftM = majorityElementRec(nums, low, mid);
    let rightM = majorityElementRec(nums, mid + 1, high);
    
    if (leftM === rightM) {
        return leftM;
    }
    
    let leftC = countInRange(nums, leftM, low, mid);
    let rightC = countInRange(nums, rightM, mid + 1, high);
    
    return leftC > rightC ? leftM : rightM;
};

var countInRange = function(nums, num, low, high) {
    let count = 0;
    for (let i = low; i <= high; i++) {
        if (nums[i] === num) {
            count++;
        }
    }
    return count++;
};