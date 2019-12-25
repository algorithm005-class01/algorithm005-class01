class Leecode_1_0116 {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i =0; i<nums.length;i++){
            map.put(nums[i],i);
        }
        //查找
        for(int j = 0 ;j <nums.length;j++){
            int val = target - nums[j];
            if(map.containsKey(val) && map.get(val)!= j ){
                result[0] = map.get(val);
                result[1] =j;
            }
        }
        return result;
    }
}