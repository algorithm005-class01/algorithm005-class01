package test;

import java.util.*;

public class ThreeSumTest {

    public static void main(String[] args) {
        int data[] = {-2,-1,0,1,2};
        List list = threeSumB(data);
        System.out.println(list.toString());
    }

    //hashmap
    public static List<List<Integer>> threeSumB(int[] data) {
        List<List<Integer>> list = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        Object key = new Object();
        for (int i = 0; i <data.length ; i++) {
            map.put(i,data[i]);
        }
        for (int j = 0; j <data.length-1 ; j++) {
            for (int k = j+1; k < data.length; k++) {
//                if(map.containsKey(-(data[j]+data[k]))){
//
//                        int kk = map.get(-(data[j]+data[k]));
////                    Object ke = map.get(key).equals(-(data[j]+data[k]));
////                    int  i = Integer.parseInt(ke.toString());
//                    list.add(Arrays.asList(data[kk], data[j], data[k]));
//                }
            }

        }

        return list;
    }

    //排序+双指针
    // 排序Arrays.sort(nums);
    public static List<List<Integer>> threeSumA(int[] data) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(data);
        for (int i = 0; i <data.length ; i++) {
            int j = i+1;
            int k =data.length-1;
            if(data[i]>0){ break; }
            if(i > 0 && data[i]==data[i+1]){ continue; }// 去重
            while(j<k){
                int result = data[i]+data[j]+data[k];
                if(result==0){
                    list.add(Arrays.asList(data[i], data[j], data[k]));
                    while (j<k && data[j] == data[j+1]) j++; // 去重
                    while (j<k && data[k] == data[k-1]) k--; // 去重

                    j++;
                    k--;
                }else if(result>0){
                    k--;
                }else if(result<0){
                    j++;
                }
            }
        }
        return list;
    }

    //暴力
    public static List<List<Integer>> threeSum(int[] data) {
        List<List<Integer>> list = new ArrayList<>();
        List<List<Integer>> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        for (int i = 0; i <= data.length-1; i++) {
            for (int j = i+1; j < data.length; j++) {
                for (int k = j+1; k <data.length ; k++) {
                    if(data[i]+data[j]+data[k]==0){
                        list.add(Arrays.asList(data[i], data[j], data[k]));
                        list1.add(Arrays.asList(i, j, k));
                        int array[] = {data[i], data[j], data[k]};
                        list2.add(Arrays.toString(array));
                    }

                }
            }
        }
        System.out.println(list.toString());
        System.out.println(list1.toString());
        System.out.println(list2.toString());
        return list;
    }

}
