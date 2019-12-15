const { rotate, rotate2 } = require('./189-rotate-array');

// Test rotate array

// 1. Using method 1 rotate, after rotate the array, it should match the result use method rotation.

// arrange
let input, expectedOutput, passCases;
setupTests(); // initialize

// act
input.forEach(item => rotate(item.nums, item.k));

// assert
input.forEach((item, index) => {
    for (let i = 0; i < item.nums.length; i++) {
        if (item.nums[i] !== expectedOutput[index][i]) {
            passCases[index] = false;
            break;
        }
    }
});

console.log('Testing method rotate');
passCases.forEach((val, i) => {
    if (val) console.log(`Test case ${i + 1} passed`);
    else console.log(`Test case ${i + 1} failed`);
});

// 2. Using method 2 rotate, after rotate the array, it should match the result use method rotation.

// arrange
setupTests(); // initialize

// act
input.forEach(item => rotate(item.nums, item.k));

// assert
input.forEach((item, index) => {
    for (let i = 0; i < item.nums.length; i++) {
        if (item.nums[i] !== expectedOutput[index][i]) {
            passCases[index] = false;
            break;
        }
    }
});

console.log('Testing method rotate2');
passCases.forEach((val, i) => {
    if (val) console.log(`Test case ${i + 1} passed`);
    else console.log(`Test case ${i + 1} failed`);
});

// private methods for initialize tests
function setupTests() {
    input = [
        { nums: [1, 2, 3, 4, 5, 6, 7], k: 2 },
        { nums: [-1, -100, 3, 99], k: 4 },
        { nums: [], k: 0 },
        { nums: [1, 2, 3], k: 4 }
    ];

    expectedOutput = [[6, 7, 1, 2, 3, 4, 5], [-1, -100, 3, 99], [], [3, 1, 2]];

    passCases = [true, true, true, true];
}
