public class LeetCode_189_0174{

    /**
     * 时间复杂度 O(N)
     * 由于新建了一个数组 所以空间复杂度O(N)
     * 该方法是自己想出来的 和官方题解 第二种方式几乎一样
     * */
    public void rotate_1(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return;
        }
        int length = nums.length;
        k %= length;
        int[] newArray = new int[length];
        for (int i = 0; i < length; i++) {
            newArray[i] = nums[i];
        }
        for (int i = 0; i < length; i++) {
            int newIndex = (i + k) % length;
            nums[newIndex] = newArray[i];
        }
    }


    /**
     * 该方法是通过官方题解4 得出来的
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     * */
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length < 2){
            return;
        }
        k %= nums.length;
        if(k == 0){
            return;
        }
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }

    public void reverse(int[] nums, int begin, int end) {
        while(i < j){
            int tmp = nums[begin];
            nums[begin] = nums[end];
            nums[end] = tmp;
            begin++;
            end--;
        }
    }
}