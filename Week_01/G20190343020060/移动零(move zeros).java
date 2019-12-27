移动零(move zeros)
//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

//解法一：所谓要把0移动到数组后面，其实就是把非0数给移动到数组前面，而每个非0数需要移动的步数其实就是这个非0数前面0的个数。

//解法二：双指针法变量j永远指向已处理好的第一个为零元素位置，依次遍历数组，每次遇到非零元素，则与第一个为零的元素j进行位置交换/

//解法三：j永远指向已处理好的第一个为零元素位置，交换两个指针所指向的元素
class Solution {
    public void moveZeroes(int[] nums) {
    	//solution1
        // int count = 0;
        // for(int i = 0; i < nums.length; i++) {
        //     if(nums[i] == 0) {
        //         count++;
        //     }else {
        //         nums[i - count] = nums[i];
        //     }
        // }
        // for(int i = nums.length - count; i < nums.length; i++) {
        //     nums[i] = 0;
        // }

    	//solutiuon2
    	// int j = 0;
    	// for (int i = 0; i<nums.length; i++) {
    	// 	if(nums[i]!=0){
    	// 		nums[j] = nums[i];
    	// 		if(j!=i) {
    	// 			nums[i] = 0;
    	// 		}
    	// 		j++;
    	// 	}
    	// }

    	//解法三
    	int j = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }   
    }
}

