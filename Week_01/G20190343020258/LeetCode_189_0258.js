var rotate = function(nums, k) {
    const re = []
    for (let i = 0; i < nums.length; i++) {
      re[(i + k) % nums.length] = nums[i]
    }
    for (let j = 0; j < nums.length; j++) {
      nums[j] = re[j]
    }
};
