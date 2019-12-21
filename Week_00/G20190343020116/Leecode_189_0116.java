class Leecode_189_0116 {

    /**
     *
     使用新数组，将原数组钟i位置的数据移动到i+k.
     空间负载度O(n) 时间负载度O(n)
     */
    public void rotate(int[] nums, int k) {

        int[] newArr = new int[nums.length];

        for (int i = 0; i < nums.length; i++){
            newArr[(i+k)%nums.length] = nums[i];
        }

        for(int i = 0; i < nums.length; i++){
            nums[i] = newArr[i];
        }

    }


}