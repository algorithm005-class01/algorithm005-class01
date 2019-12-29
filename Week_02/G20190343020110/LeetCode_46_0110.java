import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author huangxiong
 * @Date 2019/12/21
 * @Description
 **/
public class LeetCode_46_0110 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        generate(lists,nums,new Integer[nums.length],0);
        return lists;
    }

    /**
     * 递归
     * @param list
     * @param nums
     * @param current
     * @param pos
     */
    private void generate(List<List<Integer>> list,int[] nums,Integer[] current,int pos){
        if(pos == nums.length){
            list.add(new ArrayList<Integer>(Arrays.asList(current)));
            return;
        }
        for(int i = 0 ; i < nums.length; i ++){
            int value = nums[i];
            boolean isContinue = true;

            for(int j = 0 ; j < pos; j ++){
                if(current[j] == value){
                    isContinue  = false;
                    break;
                }
            }
            if(isContinue){
                current[pos] = value;
                generate(list,nums,current,pos+1);
            }
        }
    }
}
