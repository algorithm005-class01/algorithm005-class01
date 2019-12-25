/*
思路: 递推向下, 类似背包问题
C(n, k) = C(n-1, k-1) + C(n-1, k)
*/

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        if (k == n || k == 0) {
            List<Integer> currList = new ArrayList<>();
            for (int i = 1; i <= k; i++) {
                currList.add(i);
            }
            return new ArrayList<>(Arrays.asList(currList));
        }

        // n-1个数选k-1个, 结果都加上n这个数
        List<List<Integer>> result = combine(n - 1, k - 1);
        for (List<Integer> l: result) {
            l.add(n);
        }
        // n-1个数选k个, 就是不选n这个数
        List<List<Integer>> result2 = combine(n - 1, k);
        result.addAll(result2);

        return result;
    }
}