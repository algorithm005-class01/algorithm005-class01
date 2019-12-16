// 接雨水
var trap = function(height) {
    if(!height || height.length == 0){
        return 0;
    }
    let sum = 0;
    for(let i = 1;i < height.length - 1;i++){
        let max_left = 0;
        for(let j = i - 1;j >= 0;j--){
            max_left = Math.max(max_left,height[j]);
        }
        let max_right = 0;
        for(let j = i + 1;j < height.length;j++){
            max_right = Math.max(max_right,height[j])
        }
        let min = Math.min(max_left,max_right);
        if(min >  height[i]){
            sum += min - height[i];
        }
    }
    return sum;
};