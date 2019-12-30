![image-20191227094538430](/Users/marslee/Library/Application Support/typora-user-images/image-20191227094538430.png)

+ 暴力为O(n)

+ 分治解法：

  + 算一半， $y=x^[N/2], result=y*y$， [N/2]为取整
  + len为偶数找到中间点，刚好可以对半
  + len为奇数，折半会都多一个，$y=x^[N/2],result = y*y*x$

  + ![image-20191227095008405](/Users/marslee/Library/Application Support/typora-user-images/image-20191227095008405.png)
  + O(log N )

  ```python
  def myPow(self, x, n):
      #16^0
      if not n:
          return 1
      #n为负数 例 2^-5
      if n < 0:
          return 1/self.myPow(x, -n)
      #例： 2^5
      #为奇数，递归到偶数 2^4, 接到 16^1 => 16 => 2 * 16 = 32
      if n % 2：
      	return x * self.myPow(x, n-1)
      #为偶数, 2^4 => 4^2 => 16^1
      return self.myPow(x*x, n/2)
  
  
  #非递归,利用二进制，因为二进制的1原本在计算机代表次方：利用这个原理，x反复乘x即可。
  def myPow(self, x, n):
      #为负值
      if n < 0:
          x = 1 / x
          n = -n
          
      pow = 1
      #2^5
      while n:
          #5:(101)
          #2:(10)
          #1:(1)
          if n & 1:
              #n==5, => pow=2
              #n==1, => pow =16*2=32
              pow *= x
          #n==5, => x=4
          #n==2, => x=16
          #n==1, => x=16*16 //这步没用了
          x *= x
          #n==5, => n:(10)
          #n==2, => n:(1)
          n >>= 1
      #pow = 32
      return pow 
  ```

  

