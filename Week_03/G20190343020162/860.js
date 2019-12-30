/**
 * @param {number[]} bills
 * @return {boolean}
 */

// 使用贪心算法
var lemonadeChange = function(bills) {
    let five = 0
    let ten = 0
    for (var i = 0; i <= bills.length; i++) {
        if(bills[i] === 5) {
            five++
        } else if(bills[i] === 10) {
            if(five == 0) {
                return false
            }
            ten++
            five--
        } else if(bills[i] === 20) {
            if(ten>=1&&five>=1) {
                ten--
                five--
            } else if(five>=3) {
                five = five-3  
            } else {
                return false 
            }
        }
    }
    return true
};