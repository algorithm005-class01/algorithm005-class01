/*
 * @lc app=leetcode.cn id=11 lang=javascript
 *
 * [11] 盛最多水的容器
 */

//笔记
//左右边界向中间收敛，左右夹逼
//自己做时边界条件考虑不周全，不过调试多次也能做出来

// @lc code=start
/**
 * @param {number[]} height
 * @return {number}
 */
var maxArea = function (height) {
    // var res = 0;
    // for (var i = 0; i < height.length; i++) {
    //     for (var j = i + 1; j < height.length; j++) {
    //         var temp = (j - i) * Math.min(height[i], height[j]);
    //         if (temp > res) {
    //             res = temp;
    //         }

    //     }
    // }
    // return res;
    var res = 0;
    var left = 0;
    var right = height.length - 1;
    while(left < right){
        if(height[left] < height[right]){
            var temp = (right - left) * height[left];
            if(temp > res){
                res = temp;
            }
            left++;
        }else{
            var temp = (right - left) * height[right];
            if(temp > res){
                res = temp;
            }
            right--;
        }
    }
    return res;
};
// @lc code=end