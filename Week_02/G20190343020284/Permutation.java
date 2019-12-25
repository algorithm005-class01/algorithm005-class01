package work02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {

    public static void main(String[] args) {
        int nums[] = {1,2,3};
        System.out.println(permute(nums));;
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList();
        generate(list,nums,new Integer[nums.length],0);
        return list;
    }

    private static void generate(List<List<Integer>> list,int[] nums,Integer[] current,int pos){
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

