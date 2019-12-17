package com.algorithm.week01;

public class MoveZeroes {
  public void moveZeroes(int[] nums) {
    int count = 0;

    for (int i = 0; i < nums.length; i++){
      if(nums[i] == 0){
        count++;
      } else {
        nums[i-count] = nums[i];
      }
    }
    for (int i = nums.length-count;i < nums.length; i++) {
      nums[i] = 0;
    }
  }
}
//runtime:0 ms
//memory:38.4 MB

