package com.algorithm.week01;

public class RemoveDuplicates {

  public int removeDuplicates(int[] nums) {
    //排序
    //双指针- 快慢指针
    //如果前指针等于后指针 则后指针++位移，直到找到不同 将数据覆盖到前指针+1 位置
    //前指针移动 ++  后指针再从 前指针+1位置出发寻找到不同然后覆盖前指针+1 位置
    //直到后指针到数组尾部停止循环

    int p = 0;
    int q = 1;

    while (q < nums.length) {
      while (q < nums.length && nums[p] == nums[q]){
        q++;
      }
      if ( q < nums.length ) {
        nums[p+1] = nums[q];
        p++;
      }
    }
    return p+1;
  }
//runtime:1 ms
//memory:40.5 MB
}
