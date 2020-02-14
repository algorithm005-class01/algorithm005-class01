//给你两个数组，arr1 和 arr2， 
//
// 
// arr2 中的元素各不相同 
// arr2 中的每个元素都出现在 arr1 中 
// 
//
// 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末
//尾。 
//
// 
//
// 示例： 
//
// 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
//输出：[2,2,2,1,4,3,3,9,6,7,19]
// 
//
// 
//
// 提示： 
//
// 
// arr1.length, arr2.length <= 1000 
// 0 <= arr1[i], arr2[i] <= 1000 
// arr2 中的元素 arr2[i] 各不相同 
// arr2 中的每个元素 arr2[i] 都出现在 arr1 中 
// 
// Related Topics 排序 数组


package leetcode.editor.cn;

import java.util.Arrays;

public class RelativeSortArray {
    public static void main(String[] args) {
        Solution solution = new RelativeSortArray().new Solution();
        System.out.println(Arrays.toString(solution.relativeSortArray(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19},
                new int[]{2, 1, 4, 3, 9, 6})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] relativeSortArray(int[] arr1, int[] arr2) {
            //找出最大最小
            int max = arr1[0], min = arr1[0];
            for (int i = 1; i < arr1.length; i++) {
                if (arr1[i] > max) max = arr1[i];
                if (arr1[i] < min) min = arr1[i];
            }
            int[] tmp = new int[max - min + 1];
            //统计次数
            for (int i = 0; i < arr1.length; i++) {
                tmp[arr1[i] - min]++;
            }
            int[] res = new int[arr1.length];
            int index = 0, count;
            for (int i = 0; i < arr2.length; i++) {
                count = tmp[arr2[i] - min];
                while (count-- > 0) {
                    res[index++] = arr2[i];
                }
                tmp[arr2[i] - min] = 0;
            }
            for (int i = 0; i < tmp.length; i++) {
                count = tmp[i];
                while (count-- > 0) {
                    res[index++] = i + min;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}