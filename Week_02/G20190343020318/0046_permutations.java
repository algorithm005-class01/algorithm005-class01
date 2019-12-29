class Solution {
    public List<List<Integer>> permute(int[] nums) {
       List<List<Integer>> res = new ArrayList<>();
       dfs(res, new ArrayList<>(), nums);
       return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> subset, int [] nums){
       if(subset.size() == nums.length){
          res.add(new ArrayList<>(subset));
       } 
       else{
          for(int i = 0; i < nums.length; ++i){ 
             if(subset.contains(nums[i])) continue;
             subset.add(nums[i]);
             dfs(res, subset, nums);
             subset.remove(subset.size() - 1);
          }
       }
    }
}