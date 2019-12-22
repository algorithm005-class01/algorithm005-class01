var climbStairs = function(n) {
    if(n===3)return 3;
    if(n===2)return 2;
    if(n===1)return 1;
    let lastSum = 3;
    let lastSeconSum =2;
    let sum = 5;
    for(let i = 4;i<=n;i++){
        sum = lastSeconSum + lastSum;
        lastSeconSum = lastSum;
        lastSum  = sum;
    }
    return sum;
};