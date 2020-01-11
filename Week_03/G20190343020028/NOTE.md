# 【0028_week 03】我拿到了锤子~

## 胡扯

工作、学习中，我们总有一个习惯，想把自己学到的东西立刻用上。对于学习，真的是挺好的，能反复加固自己对知识的理解。工作中，还是需要多谨慎思考一下。

老师这门课教授的是锤子如何使用，具体该不该用锤子、我们砸的是钉子还是玻璃，

本周比较忙，只写了 2 道题，下周我把年假请了，复习一下我拿到的锤子，锤几个钉子，备战期中。

## 使用二分查找，寻找一个半有序数组[4, 5, 6, 7, 0, 1, 2]中间无序的地方

与【33. 搜索旋转排序数组】有着相似的内容，感觉回到了高中，老师讲完一道题，循序渐进的提出了一个需要稍进一步思考的题。甚是怀念。

33 题的结束条件是找到目标值，这道题的目标值就是无序的地方，即 `start + 1 = end` 的情况下， `num[start] > num[end]`。

### Clarification: 没有一个具体的沟通对象，我自己扮演需求方，将边界条件、有效性进行了划分（偷懒）

有些边界值、有效性的约束，我自己定义一下：

- 一个正常的升序数组，认为是有效的，最小值所在位置即拐点，例如：[1, 2, 4, 5, 6]，num[0] = 1, index = 0 即结果
- 数组内默认没有重复元素（如果有重复元素，得写好多判断，偷懒不写了）
- 数组长度都在 2 位以上（小于两位也没有探讨的必要了，当然也是为了代码上偷懒）
- 结果为拐点的下标

### Possible solutions: 题干要求使用二分法，暂时我只能想到老师讲解 33 题时的二分解法

如果使用二分法的情况下，将出现以下几种可能：

- 两边都是有序数组，那就代表整个数组都是有序的，`num[start]` 即拐点
- 一边有序 `num[start] < num[mid] || num[mid] < num[end]`，一边无序 `num[start] > num[mid || num[end] > num[mid]`
    - 有序一边一定不存在拐点
    - 无序一边，找到到相邻两个元素 `start + 1 == end && num[start] > num[end]` 即找到拐点 `num[end]`

### Coding && Test cases

``` Java
public class Inflexion {
    public static void main(String[] args) {

        int[] num_1 = {4, 5, 6, 7, 0, 1, 2};
        int result_1 = findInflexion(num_1);
        System.out.println(String.format("%s inflexion is: index [%d] - [%d]",
                Arrays.toString(num_1), result_1, result_1 == -1 ? -1 : num_1[result_1]));

        int[] num_2 = {0, 2};
        int result_2 = findInflexion(num_2);
        System.out.println(String.format("%s inflexion is: index [%d] - [%d]",
                Arrays.toString(num_2), result_2, result_2 == -1 ? -1 : num_2[result_2]));

        int[] num_3 = {4, 3};
        int result_3 = findInflexion(num_3);
        System.out.println(String.format("%s inflexion is: index [%d] - [%d]",
                Arrays.toString(num_3), result_3, result_3 == -1 ? -1 : num_3[result_3]));

        int[] num_4 = {4, 5, 6, Integer.MAX_VALUE, Integer.MIN_VALUE};
        int result_4 = findInflexion(num_4);
        System.out.println(String.format("%s inflexion is: index [%d] - [%d]",
                Arrays.toString(num_4), result_4, result_4 == -1 ? -1 : num_4[result_4]));

    }

    public static int findInflexion(int[] num) {
        int start = 0;
        int end = num.length - 1;
        while (start + 1 <= end) {
            // 两元素相邻，即终结情况
            if (start + 1 == end) {
                // 前一元素大于后一元素，即找到拐点
                if (num[start] > num[end]) {
                    return end;
                }
                // 最终无拐点：仅有两个元素，且数组有序的情况
                break;
            }

            int mid = start + (end - start) / 2;
            // 两边都是有序的，则认为 num[0] 即拐点
            if (num[start] < num[mid] && num[mid] < num[end]) {
                return start;
            }

            // 前半段无序，则继续向前半段二分查找
            if (num[start] > num[mid]) {
                end = mid;
            } else if (num[mid] > num[end]) {
                start = mid;
            }
        }
        // 仅有两个元素，且数组有序的情况下，会从上面的判断中跳出，默认第一个元素即拐点
        return 0;
    }
}
```

``` Shell
result: 
[4, 5, 6, 7, 0, 1, 2] inflexion is: index [4] - [0]
[0, 2] inflexion is: index [0] - [0]
[4, 3] inflexion is: index [1] - [3]
[4, 5, 6, 2147483647, -2147483648] inflexion is: index [4] - [-2147483648]
```

---

二分法进行『有序』查找时将效率提升到了 O(logN)，日常业务中应用到的场景应该还是很多的，希望能切实在工作中使用到。（好了，我拿到了锤子，我看看有多少个 ```钉子``` 可以让我捶打一下~）
