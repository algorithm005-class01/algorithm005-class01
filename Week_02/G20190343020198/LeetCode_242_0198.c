//
//  LeetCode_242_0198.c
//  LeetCode-week-02
//
//  Created by lcf on 2019/12/21.
//  Copyright © 2019 lcf. All rights reserved.
//

#include "LeetCode_242_0198.h"
#include <string.h>
#include <stdbool.h>

/*
 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

 示例 1:

 输入: s = "anagram", t = "nagaram"
 输出: true
 示例 2:

 输入: s = "rat", t = "car"
 输出: false
 说明:
 你可以假设字符串只包含小写字母。

 进阶:
 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */

bool isAnagram(char * s, char * t){
    // 获取长度,长度如果不相等,返回 true
    int slen = (int)strlen(s);
    int tlen = (int)strlen(t);
    if (slen != tlen) {
        return false;
    }
    // 英文有 26 个字母,这里定义一个容量为 26 的数组
    int targets[26] = {0};
    for (int i = 0; i < slen; ++i) {
        // 因为字母 a,是 26 个字母的首位,其他字母都排在后面,各自相差 1,
        // 这里是把 s 和 t 对应位置的值进行 +1 和 -1 操作,
        // 如果 s 和 t 所含有字符相同,最后还是会得到一个都是 0 的数组
        targets[s[i] - 'a']++;
        targets[t[i] - 'a']--;
    }
    for (int i = 0; i < 26; ++i) {
        if (targets[i] != 0) {
            return false;
        }
    }
    return true;
}
