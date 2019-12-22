// 方法二：哈希表 时间复杂度 O(n) 
// 84ms 快，两个循环

var isAnagram = function(s, t) {
    if (s.length !== t.length) return false;

    let map = {};
    let flag = true;

    s.split('').forEach(item => {
        map[item] ? map[item]++ : map[item] = 1;
    });

    for (var i = 0; i < t.length; i++) {
        if (map[t[i]] && map[t[i]] > 0) {
            map[t[i]]--;
        } else {
            flag = false;
            break;
        }
    }

    return flag;
};