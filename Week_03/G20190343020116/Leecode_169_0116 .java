import java.util.HashMap;
import java.util.Map;

class Leecode_169_0116 {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i ++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }else{
                map.put(nums[i],map.get(nums[i])+1);
            }
        }

        for(Map.Entry<Integer,Integer> entry :map.entrySet()){
            if(entry.getValue() > nums.length/2){
                return entry.getKey();
            }

        }
        return -1;
    }
}