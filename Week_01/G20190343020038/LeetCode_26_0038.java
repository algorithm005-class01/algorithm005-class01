//去除数组中重复的元素，返回最后的数组长度值
    
// Case:    [1,1,2,2,3,4,5,6]
//                 i
//              c
// Result: [1,2,3,4,5,6,]
//双指针思路
//数组比较有无重复，都是当前项跟前面的一项比较。
//链表都是当前项的跟后面下一项比较。
public int removeDuplicates(int[] nums) {
    If (nums==null || nums.length==0){ //边界条件
        return 0;
    }
    int count=1;//从第二项开始，第一项默认保留
    for (int i=1; i<nums.length; i++) {
        if (nums[i-1] != nums[i]) {//判断当前项与前一项是否不一样
            nums[count] = nums[i];//只要不一样就保留到count指针指向的位置。
            count++;
        }
    }
    return count;
}
