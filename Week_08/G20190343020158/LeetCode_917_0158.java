class Solution {

    /**
     * 思路：双指针，遍历字符串，跳过不是字母的字符，交换首尾元素
     *
     * @param S
     * @return
     */
    public String reverseOnlyLetters(String S) {
        StringBuilder res = new StringBuilder(S);
        int i = 0, j = S.length() - 1;
        while (i < j) {
            while (i < j && !Character.isLetter(S.charAt(i))) i++;
            while (i < j && !Character.isLetter(S.charAt(j))) j--;
            res.setCharAt(i, S.charAt(j));
            res.setCharAt(j, S.charAt(i));
            i++;
            j--;
        }
        return res.toString();
    }
}