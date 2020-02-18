class Solution {
    /**
     * 思路：根据空格分隔字符串后，通过收尾双指针交换元素
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        String str = s.trim();

        String[] res = str.split(" +");
        int i = 0, j = res.length - 1;
        while (i < j) {
            String temp = res[i];
            res[i] = res[j];
            res[j] = temp;
            i++;
            j--;
        }

        return String.join(" ", res);
    }
}