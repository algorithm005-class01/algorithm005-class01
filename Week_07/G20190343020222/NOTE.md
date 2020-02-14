学习笔记
1. 去掉二进制数最低位的1
x & (x - 1)
2. n之前的高位全部赋零， 可用于N皇后问题判断当前层的剪枝
（(1 << n) - 1）& ...
3. 快排
var sortArray = function(nums) {    
    // Quick sort
//     if (!nums || nums.length < 2) {
//         return;
//     }
    
//     let partitionIndex = partition(nums, 0, nums.length - 1);
    
//     sortArray(nums.slice(0, partitionIndex));
//     sortArray(nums.slice(partitionIndex + 1))
    
    if (!nums || nums.length < 2) {
        return nums;
    }
    
    return quickSort(nums, 0, nums.length - 1); 
};
var quickSort= function(nums, left, right) {
  if (left < right) {
    let partitionIndex = partition(nums, left, right);
    
    quickSort(nums, left, partitionIndex - 1);
    quickSort(nums, partitionIndex + 1, right);
  }  
    
  return nums;
};

var partition = function(array, start, end) {
    let pointer = start;
    let pivot = array[end];
    for (let i = start; i < end; i++) {
        if (array[i] < pivot) {
            const tmp = array[i];
            array[i] = array[pointer];
            array[pointer++] = tmp;
        }
    } 

    const tmp = array[pointer];
    array[pointer] = array[end];
    array[end] = tmp;
    return pointer;
};

var merge = function(array, left, right) {
    let i = 0;
    let j = 0;
    let k = 0;

    while (i < left.length && j < right.length) {
        if (left[i] < right[j]) {
            array[k] = left[i];
            i++;
        } else {
            array[k] = right[j];
            j++;
        }
        k++;
    }

    while (i < left.length) {
        array[k++] = left[i++];
    }

    while (j < right.length) {
        array[k++] = right[j++];
    }

    return array;
};

4. 选择排序
var sortArray = function(nums) {
    // selection sort
    for (let i = 0; i < nums.length - 1; i++) {
        let minIndex = i;
        for (let j = i + 1; j < nums.length; j++) {
            if (nums[j] < nums[minIndex]) {
                minIndex = j;
            }
        }
        
        const temp = nums[minIndex];
        nums[minIndex] = nums[i];
        nums[i] = temp;
    }
    
    return nums;
};
5. 归并排序
var sortArray = function(nums) {
    // merge sort
    if (!nums || nums.length < 2) {
        return nums;
    }
    
    const mid = Math.floor(nums.length / 2);
    const left = sortArray(nums.slice(0, mid));
    const right = sortArray(nums.slice(mid));
    return merge(nums, left, right);
};