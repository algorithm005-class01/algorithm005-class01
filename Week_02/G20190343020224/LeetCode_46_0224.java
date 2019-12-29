//回溯
class Solution {

    List<List<Integer>> output;

    public List<List<Integer>> permute(int[] nums) {
        output = new ArrayList<>();
        trackBack(nums, new ArrayList<>());
        return output;
    }

    public void trackBack(int[] nums, List<Integer> res) {
        if (res.size() == nums.length) {
            output.add(new ArrayList<>(res));
            return;
        }
        for (int i : nums) {
            if (!res.contains(i)) {
                res.add(i);
                trackBack(nums, res);
                res.remove(new Integer(i));
            }
        }
    }
}