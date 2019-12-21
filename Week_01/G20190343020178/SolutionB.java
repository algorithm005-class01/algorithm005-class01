//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
//
// 示例 1:
//
// 输入: [1,2,3,4,5,6,7] 和 k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右旋转 1 步: [7,1,2,3,4,5,6]
//向右旋转 2 步: [6,7,1,2,3,4,5]
//向右旋转 3 步: [5,6,7,1,2,3,4]
//
//
// 示例 2:
//
// 输入: [-1,-100,3,99] 和 k = 2
//输出: [3,99,-1,-100]
//解释:
//向右旋转 1 步: [99,-1,-100,3]
//向右旋转 2 步: [3,99,-1,-100]
//
// 说明:
//
//
// 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
// 要求使用空间复杂度为 O(1) 的 原地 算法。
//
// Related Topics 数组



//leetcode submit region begin(Prohibit modification and deletion)
class SolutionB {
    public void rotate(int[] nums, int k) {
        //4反转
        k = k % nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);

    }
    public void reverse(int[] nums, int s,int e){
        while (s < e){
            int  temp = nums[s];
            nums[s] = nums[e];
            nums[e] = temp;
            s++;
            e--;
        }
    }




//        //3 额外数组
//        int n = nums.length;
//        k = k % nums.length;
//        if(k>0){
//            int[] a = new int[k];
//            for(int i = 0;i < k; i++){
//                a[i] = nums[i];
//            }
////   //         for(int i= 0 ;i<n - k;i++){
////  //              nums[i] = nums[(k+i) % n];
////  //          }
//            for (int i = n-1;i>=k;i--){ // n=4 k=2
//                int newIndex = (i + k) % n;
//                nums[newIndex] = nums[i];
//            }
//            for(int i = 0;i < k;i++){
//                nums[(i+k) % n] = a[i];
//            }
//        }
//        //2 额外数组
//        int n = nums.length;
//        int[] a = new int[n];
//        for (int i = 0;i < n; i++){
//            a[(i + k) % n] = nums[i];
//        }
//        for(int i = 0;i < n; i++){
//            nums[i] = a[i];
//        }



//        1.暴力
//        int temp,pre;
//        for(int i = 0;i < k;i++){
//          pre = nums.length-1;
//          for(int j = 0;j < nums.length;j++){
//              temp = nums[j];
//              nums[j] = nums[pre];
//              nums[pre] = temp;
//          }
//        }
    //}
}
//leetcode submit region end(Prohibit modification and deletion)
