public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> totalResult = new ArrayList<>();
        if (nums.length == 0) {
            return totalResult;
        }
        recurrPermutation(nums, 0, nums.length, totalResult);
        return totalResult;
    }

    private void recurrPermutation(int[] nums, int begin, int len, List<List<Integer>> totalResult) {
        if (begin == len) {
            List<Integer> currRessult = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                currRessult.add(nums[i]);
            }
            totalResult.add(currRessult);
        }

        for (int i = begin; i < len; i++) {
            //从begin开始, 交换到需要的位置, begin为当前递归数组的第一位的下一位
            swap(nums, begin, i);
            //从begin-1再递归求解
            recurrPermutation(nums, begin + 1, len, totalResult);
            //需要再交换回来，不能改变原数组的顺序
            swap(nums, begin, i);
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        if (index1 == index2) {
            return;
        }
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }