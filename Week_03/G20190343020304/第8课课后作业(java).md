### 课后第一题-多数元素


给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

你可以假设数组是非空的，并且给定的数组总是存在多数元素。

例:

```
输入: [3,2,3]
输出: 3

输入: [2,2,1,1,1,2,2]
输出: 2

```



* 方法一排序

```java 
 public int majorityElement(int[] nums) {
    Arrays.sort(nums);
    int index = nums.length / 2;
    return nums[index];
 }       
```

* 方法二暴力

```java 
   public int majorityElement(int[] nums) {
         int maxNum = nums.length / 2;
        for (int num : nums) {
            int tempCount = 0;
            for (int num1 : nums) {
                if (num == num1) {
                    tempCount++;
                }
            }
            if (tempCount > maxNum) {
                return num;
            }
        }
        return -1;
    }
        
```