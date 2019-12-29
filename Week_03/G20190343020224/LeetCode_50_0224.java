//1.暴力递归，stack over flow
class Solution {
    public double myPow(double x, int n) {
        Stack<Double> result = new Stack<>();
        result.push(1D);
        helper(x, n, result);
        return result.pop();
    }

    public void helper(double x, int n, Stack<Double> result) {
        if (n == 0) {
            return;
        }
        result.push(result.pop() * (n > 0 ? x : (1 / x)));
        helper(x, n - 1, result);
    }
}

//2.暴力循环，超时
public double myPow(double x, int n) {
    Double result = 1D;
    while (n != 0) {
        result = result * (n-- > 0 ? x : 1 / x);
    }
    return result;
}

//3.分治，还是爆栈
class Solution {

    public double myPow(double x, int n) {
        return devideConquer(x, n);
    }

    public double devideConquer(double x, int n) {
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1 / x;
        }
        int subMid1 = n / 2;
        int subMid2 = n - subMid1;
        Double sub1 = devideConquer(x, subMid1);
        Double sub2 = devideConquer(x, subMid2);
        return sub1 * sub2;
    }

}
//4.优化分治
class Solution {

    public double myPow(double x, int n) {
        double xx = x;
        long nn = n;
        if (n < 0) {
            xx = 1 / x;
            nn = -nn;
        }
        return devideConquer(xx, nn);
    }

    public double devideConquer(double x, long n) {
        if (n == 0) {
            return 1D;
        }
        double subResult = devideConquer(x, n / 2);
        return n % 2 == 1 ? subResult * subResult * x : subResult * subResult;
    }

}

//5.牛顿迭代
