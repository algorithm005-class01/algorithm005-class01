var moveZeroes = function(nums) {        
    let j = 0
    for (let i = 0; i < nums.length; i++) {
      if (nums[i] != 0 ) {
        if (i !== j) {
          nums[j] = nums[i]
          nums[i] = 0     
        }
        j++
      }
    }
  }