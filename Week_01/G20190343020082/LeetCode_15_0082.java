import java.util.*;

public class LeetCode_15_0082 {

    public List<List<Integer>> threeSum(int[] nums) {
        // 暴力循环
        // 哈希表
        // 双指针
//        Map<Integer, Integer> hash = new HashMap<>();
//        List<List<Integer>> result = new ArrayList<>();
//        for (int num : nums) {
//            hash.compute(num, (k, v) -> v == null ? 1 : v + 1);
//        }
//        List<Integer> list = new ArrayList<>(hash.keySet());
//        Collections.sort(list);
//        for (int i = 0; i < list.size() - 1; i++) {
//            for (int j = i + 1; j < list.size(); j++) {
//                if (list.get(i) * 2 + list.get(j) == 0 && hash.get(list.get(i)) > 1) {
//                    result.add(Arrays.asList(list.get(i), list.get(i), list.get(j)));
//                } else if (list.get(i) + list.get(j) * 2 == 0 && hash.get(list.get(j)) > 1) {
//                    result.add(Arrays.asList(list.get(i), list.get(j), list.get(j)));
//                } else if (hash.containsKey(-list.get(i) - list.get(j)) && -list.get(i) - list.get(j) > list.get(j)) {
//                    result.add(Arrays.asList(list.get(i), list.get(j), -list.get(i) - list.get(j)));
//                }
//            }
//        }
//        if (hash.containsKey(0) && hash.get(0) >= 3) {
//            result.add(Arrays.asList(0, 0, 0));
//        }
//        return result;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    j ++;
                } else if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j] == nums[j + 1])  j ++;
                    while (j < k && nums[k] == nums[k - 1])  k --;
                    j ++;
                    k --;
                } else {
                    k --;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode_15_0082().threeSum(new int[]{-1,0,1,2,-1,-4}));
    }

}
