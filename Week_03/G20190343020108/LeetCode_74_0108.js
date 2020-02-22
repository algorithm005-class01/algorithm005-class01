/**
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */
var searchMatrix = function(matrix, target) {
    if (!matrix || matrix.length == 0) return false;
    let m = matrix.length;
    let n = matrix[0].length;
    let low = 0;
    let high = m * n - 1;
    let mid = 0,
        x = 0,
        y = 0;
    while (low <= high) {
        mid = low + ((high - low) >> 1);
        x = Math.floor(mid / n);
        y = Math.floor(mid % n);
        if (matrix[x][y] == target) return true;
        else if (matrix[x][y] < target) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
    return false;
};
