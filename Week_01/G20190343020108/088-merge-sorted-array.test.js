const merge = require('./088-merge-sorted-array');

// Test merge sorted array
// 1. given two array, the first array should contain the merged results

// arrange
const nums1 = [1, 2, 3, 5, 0, 0, 0];
const m = 4;
const nums2 = [2, 5, 6];
const n = 3;
const expectedOutput = [1, 2, 2, 3, 5, 5, 6];
let pass = true;

// act
merge(nums1, m, nums2, n);
for (let i = 0; i < nums1.length; i++) {
    if (nums1[i] !== expectedOutput[i]) {
        pass = false;
        break;
    }
}

// assert
if (pass) console.log('num1 and expectedOutput are deep equal');
else console.log('tests failed');
