# 学习笔记

## 283. 移动零

视频课程中的例题，按照老师教授的方法，先查看了国内与国外的解法，然后尝试按自己的理解去提交了。

``` Java
class Solution {
    public void moveZeroes(int[] nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0 && fast != slow) {
                nums[slow++] = nums[fast];
                nums[fast] = 0;
            }
        }
    }
}

```

第一次报错了，只想着快慢指针不一样的时候把『快指针』替换到『慢指针』，再将『快指针』置零。这种方式没有考虑到可能根本不存在0元素的情况，而且快慢指针不一致的情况下就交换，也打乱了顺序。


``` Java
class Solution {
    public void moveZeroes(int[] nums) {
        // 使用双指针，将快指针遇到的非零元素与 0 值元素交换
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            // 快指针找到非零元素
            if (nums[fast] != 0) {
                // 快慢指针不是同一元素
                if (fast != slow) {
                    // 慢指针修改为非零元素
                    nums[slow] = nums[fast];
                    // 快指针修改为 0
                    nums[fast] = 0;
                }
                // 慢指针前进
                slow++;
            }
        }
    }
}
```

修改后重新提交成功

## 11. 盛最多水的容器

查看题解后，发现官方第二种解题思路很巧妙。

最短的模板决定了当前桶的容积，如果不变更最短木板，还减少桶的宽度，容积一定是减少的。所以每次将较短的木板替换（向内移动），当前容积与记录下的最大容积比较，取最大值即可。

``` Java
class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            // 已记录的最大面积与当前左右指针面积相比，取最大的
            // 当前左右指针围成的面积 = min(左高, 右高) * (右长 - 左长)
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
            // 两指针高度较小的，向内移动
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return maxArea;
    }
}
```

## 70. 爬楼梯

暴力算法一开始就想到了，然后查看题解。看到后面的时候真的是满脸懵逼……

后续理解了一下『记忆化递归』与『动态规划』，实际上我觉得都是使用了『动态规划』的思想，将大问题切分为小的问题，并将小问题记录下来，避免重复的计算小问题。

``` Java
class Solution {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
```

## 15. 三数之和

用最热题解里的评论来说，我好像不具备人类的聪明才智。

``` Java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            // 如果最小值大于0，和一定大于0，不符合要求
            if (nums[i] > 0) {
                return result;
            }
            // 最小值相同的情况下，属于重复情况
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) { // 三数之和为0，即所求解，将当前组合计入返回结果
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right - 1] == nums[right]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}
```

## 1. 两数之和

看完三数之和，再来回顾两数之和，比较好理解了。

`X + Y = N` 即 `Y = N - X`，使用这个思路即可减少一次嵌套循环。

``` Java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = null;
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                result = new int[]{map.get(complement), i};
                break;
            }
            map.put(nums[i], i);
        }
        return result;
    }
}
```
