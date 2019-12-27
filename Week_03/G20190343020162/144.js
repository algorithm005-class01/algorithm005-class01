var preorderTraversal = function(root) {
    let arr = [], res = []
    root && arr.push(root)

    while(arr.length > 0) {
        let cur = arr.pop()
        res.push(cur.val)

        cur.right && arr.push(cur.right)
        cur.left && arr.push(cur.left)
    }
    return res
};