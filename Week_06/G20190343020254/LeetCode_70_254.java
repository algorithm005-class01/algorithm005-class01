class Solution {
    private int[] records;
    public int climbStairs(int n) {
        if(n <= 1){
            return n;
        }else if(n == 2){
            return 2;
        }else{
            records = new int[n + 1];
            Arrays.fill(records, -1);
            records[0] = 0;
            records[1] = 1;
            records[2] = 2;
            helper(n, 3);

            return records[n];
        }
    }

    private void helper(int n, int cur){
        if(cur > n) {
            return ;
        }

        // 当前结点没有计算过
        if(records[cur] == -1 ) {
            records[cur] = records[cur -1] + records[cur -2];
        }

        helper(n, cur+1);
    }
}