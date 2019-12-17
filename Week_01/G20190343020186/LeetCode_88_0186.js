var merge = function(nums1, m, nums2, n) {
    let i = m - 1
    let j = n - 1
    let p =  m + n - 1
  
    while (i >= 0 && j >= 0) {
      if (nums1[i] < nums2[j]) {
         nums1[p--] = nums2[j--]
      } else {
         nums1[p--] = nums1[i--]      
      }
    }
  
     while (i >= 0) {
       nums1[p--] = nums1[i--]
     }
  
     while (j >= 0) {
       nums1[p--] = nums2[j--]
     }
  
    
  }