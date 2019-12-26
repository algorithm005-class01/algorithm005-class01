import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_78_0190 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        backTrack(lists, new ArrayList<>(), nums, 0);
        return lists;
    }

    private void backTrack(List<List<Integer>> lists, List<Integer> tempList, int[] nums, int start) {
        lists.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backTrack(lists, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
