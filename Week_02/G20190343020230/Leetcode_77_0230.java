package week02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leetcode_77_0230 {

    public List<List<Integer>> combine(int n, int k) {
        LinkedList<Integer> nums = new LinkedList<Integer>();
        for (int i = 1; i < k + 1; ++i)
            nums.add(i);
        nums.add(n + 1);

        List<List<Integer>> output = new ArrayList<List<Integer>>();
        int j = 0;
        while (j < k) {
            output.add(new LinkedList(nums.subList(0, k)));
            // if nums[j] + 1 != nums[j + 1]
            j = 0;
            while ((j < k) && (nums.get(j + 1) == nums.get(j) + 1))
                nums.set(j, j++ + 1);
            nums.set(j, nums.get(j) + 1);
        }
        return output;
    }

}
