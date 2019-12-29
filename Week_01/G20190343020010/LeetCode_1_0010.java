
/**
 * xiezhilin
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_1_0010 {

    //对于排好序的数组用一层for循环，夹逼的方式完成
    //但此题目是要输出数组下标，一旦排序，下标会变，是否还需要额外数组拷贝，空间换时间？
    // public int[] twoSum(int[] nums, int target) {
    //     int i = 0, j = nums.length -1;
    //     for(;;){
    //         int sum = nums[i] + nums[j];
    //         if(sum == target){
    //             return new int[]{i ,j};
    //         } else if(sum < target){
    //             i++;
    //         }else{
    //             j--;
    //         }
    //         if(i >= j){
    //             break;
    //         }
    //     }
    //     return null;
    // }






    //暴力求解 双层for循环
    // public int[] twoSum(int[] nums, int target) {
    //     for(int i = 0 ; i < nums.length - 1; i++){
    //         for(int j = i+1; j < nums.length; j++){
    //             if(nums[i] + nums[j] == target){
    //                 return new int[]{i, j};
    //             }
    //         }
    //     }
    //     return null;
    // }
}
