# 169. 多数元素

> 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
>
> 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
>
> 示例 1:
>
>```
> 输入: [3,2,3]
> 输出: 3
>```
>
> 示例 2:
>
>```
> 输入: [2,2,1,1,1,2,2]
> 输出: 2
>```

## 解题思路

### 1. 暴力求解

暴力算法遍历整个数组，然后用另一重循环统计每个数字出现的次数。将出现次数比其他数字加起来出现次数还多的元素返回。

```java
class Solution {
    public int majorityElement(int[] nums) {
        int majorityCount = nums.length/2;

        for (int num : nums) {
            int count = 0;
            for (int elem : nums) {
                if (elem == num) {
                    count += 1;
                }
            }

            if (count > majorityCount) {
                return num;
            }

        }

        return -1;    
    }
}
```

### 2. 哈希表

```java
class Solution {
    private Map<Integer, Integer> countNums(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (!counts.containsKey(num)) {
                counts.put(num, 1);
            }
            else {
                counts.put(num, counts.get(num)+1);
            }
        }
        return counts;
    }

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> counts = countNums(nums);

        Map.E***y<Integer, Integer> majorityE***y = null;
        for (Map.E***y<Integer, Integer> e***y : counts.e***ySet()) {
            if (majorityE***y == null || e***y.getValue() > majorityE***y.getValue()) {
                majorityE***y = e***y;
            }
        }

        return majorityE***y.getKey();
    }
}
```

### 3.排序

```java
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
```