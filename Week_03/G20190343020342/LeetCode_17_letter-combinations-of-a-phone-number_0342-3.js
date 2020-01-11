// reduce
// 需要处理重复字符情况
var letterCombinations = function (digits) {
    if (digits.length < 1) return []

    var dict = [
        { num: 2, alphabet: ['a', 'b', 'c']},
        { num: 3, alphabet: ['d', 'e', 'f']},
        { num: 4, alphabet: ['g', 'h', 'i']},
        { num: 5, alphabet: ['j', 'k', 'l']},
        { num: 6, alphabet: ['m', 'n', 'o']},
        { num: 7, alphabet: ['p', 'q', 'r', 's']},
        { num: 8, alphabet: ['t', 'u', 'v']},
        { num: 9, alphabet: ['w', 'x', 'y', 'z']},
    ]

    if (digits.length === 1) return dict.filter(item => ~digits.indexOf(item.num))[0].alphabet;

    return dict.filter(item => ~digits.indexOf(item.num)).map(item => item.alphabet).reduce((a, b) => {
        let t = a.map(item=> {
                return b.map(i=> {
                    return [...item, i]
                })
            });
    
        let f = t.reduce((c, d)=> {
                return c.concat(d)
        }, [])
        return f;
    }).map(item => item.join(''));
};