# Pow(x, n)
## 题目
力扣50题自己实现一个幂函数Pow(x,n)
## 思路
- 使用循环实现， 这个思路最容易想到。
- 优化思路减少乘法的次数，如果循环则需要n次。比如要计算x^2k只需要计算x^k乘x^k就可以了

## 题解
### 暴力计算(会超时)
```c
double myPow(double x, int n) {
        double result = 1;
        int flag = 0;
        if(n<0) {
            flag = 1;
            n = -n;
        }
        for (int i = 0; i < n; i++) {
            result = result*x;
            /* code */
        }
        if ( flag == 1)
            return 1.0/result;
        return result;
        
    }
```
### 递归求解一(还是超时了)
(x, n) -> (x, n/2 取下底层) * (x, n/2 取上底)，但是这个方法仍旧是超时了
```c
double myPow(double x, int n) {
        int flag = 0;
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if(n < 0 ){
            flag = 1;
            n = -n;
        }
        if(flag ==1 )
            return 1.0/myPow(x, n/2) / myPow(x, n-n/2);
        else 
            return myPow(x, n/2) * myPow(x, n-n/2);
    }
```
分析这种方法的缺点，虽然看着似乎是递归求解了但实际上求解比如说x的平方实际上也是求解了多次。所以改进的话可以使用先计算打表来实现(但是打表。。。。这个n的范围太大了这方法也不太好)，最后看了下题解，改写成(x, n)->(x , n/2)^2 这种写法比较好。

### 快速幂法
在前面递归的基础上进行改进,我自己的代码写的比较垃圾，嗯呢可以看看官方题解，把快速幂提出来写比较好看不让判断n的正负有点丑。这里需要注意的是很多地方都会碰到程序边界的一个问题，要把一个负数变成正数会有一个边界溢出的问题，这题的测试用例里面有这个问题。所以把n处理为longlong 类型会好一点。
```c
class Solution {
public:
    double myPow(double x, int n) {
        long long N = n;
        int flag = 0;
        if (N == 0) {
            return 1;
        }

        if(N < 0 ){
            flag = 1;
            n = -n;
            N = -N;
        }

        if(flag ==1 ){
            double half = myPow(x, N/2);
            if(N%2==1)
                return 1.0/half/half/x;
            else
                return 1.0/half/half;
        }

            
        else {
            double half = myPow(x, N/2);
            if(N%2==1)
                return half*half*x;
            else
                return half*half;
        }
    }

};
```
### 快速幂循环法
这个方法其实可以把n的次数转化成二进制，然后累加。具体参考题解。我自己没写。

