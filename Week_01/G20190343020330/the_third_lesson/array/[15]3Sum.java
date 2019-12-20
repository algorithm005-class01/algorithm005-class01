//给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针



//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> res = new LinkedList<>();
//        HashSet<List<Integer>> set = new HashSet<>();
//        Arrays.sort(nums);
//        for (int i = 0; i < nums.length - 2; i++) {
//            for (int j = i + 1; j < nums.length - 1; j++) {
//                for (int k = j + 1; k < nums.length; k++) {
//                    if (nums[i] + nums[j] + nums[k] == 0) {
//                        set.add(Arrays.asList(nums[i], nums[j], nums[k]));
//                    }
//                }
//            }
//        }
//        for (List<Integer> i : set) {
//            res.add(i);
//        }
//        return res;
//    }
//}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                int j = i + 1, k = nums.length - 1;
                while (j < k) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        while (j < k && nums[j] == nums[j+1]) {
                            j++;
                        }
                        while (j < k && nums[k] == nums[k-1]) {
                            k--;
                        }
                        j++;
                        k--;
                    } else if (nums[i] + nums[j] + nums[k] < 0) {
                        while (j < k && nums[j] == nums[j+1]) {
                            j++;
                        }
                        j++;
                    } else {
                        while (j < k && nums[k] == nums[k-1]) {
                            k--;
                        }
                        k--;
                    }
                }
            }
        }
        return res;
    }
}

//class Solution {
//    public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> res = new LinkedList<>();
//        HashSet<List<Integer>> set = new HashSet<>();
//        Arrays.sort(nums);
//        for (int i = 0; i < nums.length - 2; i++) {
//            int j = i + 1, k = nums.length - 1;
//            while (j < k) {
//                if (nums[i] + nums[j] + nums[k] == 0) {
//                    set.add(Arrays.asList(nums[i], nums[j], nums[k]));
//                    j++;
//                    k--;
//                } else if (nums[i] + nums[j] + nums[k] < 0) {
//                    j++;
//                } else {
//                    k--;
//                }
//            }
//        }
//        for (List<Integer> i : set) {
//            res.add(i);
//        }
//        return res;
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)
