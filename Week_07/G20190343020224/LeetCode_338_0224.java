class Solution {

    /* 动态规划只要能从小数的1个数推断出大的都行 不一定非要x&(x - 1) */
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        for (int i = 1; i < num + 1; i++) {
            result[i] = result[i & (i - 1)] + 1;
        }
        return result;
    }
}