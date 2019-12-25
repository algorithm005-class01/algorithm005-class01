package G20190343020220.leetcode_47_0220;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Darcy
 * @date 2019-12-20 19:32
 */
public class Sulotion {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int[] visited = new int[nums.length];
        Arrays.sort(nums);
        fun(list, nums, new ArrayList<>(), visited);
        return list;
    }

    public void fun(List<List<Integer>> list, int[] nums, ArrayList<Integer> arr, int[] visited) {
        if (arr.size() == nums.length) {
            list.add(new ArrayList<>(arr));
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1 || (i > 0 && visited[i - 1] == 0 && nums[i - 1] == nums[i])) {
                continue;
            }
            visited[i] = 1;
            arr.add(nums[i]);
            fun(list, nums, arr, visited);
            arr.remove(arr.size() - 1);
            visited[i] = 0;
        }
    }

}
