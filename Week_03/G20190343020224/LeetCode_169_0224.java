class Solution {

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> stat = new HashMap<>();
        for (int num : nums) {
            if (stat.containsKey(num)) {
                stat.put(num, stat.get(num) + 1);
            } else {
                stat.put(num, 1);
            }
        }
        int maj = 0;
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : stat.entrySet()){
            if (entry.getValue() > count) {
                maj = entry.getKey();
                count = entry.getValue();
            }
        }
        return maj;
    }
}