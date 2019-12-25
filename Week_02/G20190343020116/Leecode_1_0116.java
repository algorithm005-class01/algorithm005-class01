import java.util.HashMap;
import java.util.Map;

class Leecode_1_0116 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for( int i = 0; i < nums.length; i++){
            int number = target -nums[i];
            if(map.containsKey(number)){
                return new int[]{map.get(number),i};
            }
            map.put(nums[i],i);
        }
        return null;

    }


    }
}