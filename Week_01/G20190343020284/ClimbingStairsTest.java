package test;

public class ClimbingStairsTest {

    public static void main(String[] args) {

        int nCount = climbStairs(5);
        System.out.println(nCount);
    }


//    n=1  1
//    n=2  2
//    n3=n1+n2
//    n4=n3+n2

    public static int climbStairs(int n){
        int n1Count = 1;
        int n2Count = 2;
        int nCount = 0;
        if(n==1){
            return n1Count;
        }
        if(n==2){
            return n2Count;
        }
        for (int i = 3; i <= n; i++) {
            nCount = n1Count + n2Count;

            n1Count = n2Count;
            n2Count = nCount;
        }
        return nCount;
    }

}
