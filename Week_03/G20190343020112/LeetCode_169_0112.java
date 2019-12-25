
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}


// 效率太低下面这个

/*class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0, e = 0;
        for (Integer n : nums) {
            if (!map.containsKey(n)) {
                map.put(n, 1);
            }else {
                Integer c = map.get(n);
                map.put(n, ++c);
            }
            if (map.get(n) > max) {
                e = n;
                max = map.get(n);
            }
        }
        return e;
    }
}*/