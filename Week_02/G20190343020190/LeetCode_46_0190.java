import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LeetCode_46_0190 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new LinkedList<>();
        ArrayList<Integer> numsList = new ArrayList<>(nums.length);
        for (int num : nums)
            numsList.add(num);

        this.backTrack(nums.length, numsList, output, 0);
        return output;
    }

    private void backTrack(int length, ArrayList<Integer> numsList, List<List<Integer>> output, int first) {
        if (first == length) output.add(new ArrayList<>(numsList));
        for (int i = first; i < length; i++) {
            Collections.swap(numsList, first, i);
            this.backTrack(length, numsList, output, first + 1);
            Collections.swap(numsList, first, i);
        }
    }
}
