public class LeetCode_70_0120 {
    public int climbStairs(int n) {
        if(n<=2) return n;
        int[] up = new int[n+1];
        up[1]=1;
        up[2]=2;
        for(int i=3;i<=n;i++){
            up[i]=up[i-1]+up[i-2];
        }
        return up[n];
    }
}
