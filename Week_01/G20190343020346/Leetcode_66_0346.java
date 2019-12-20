class Solution {
    public int[] plusOne(int[] digits) {
        int carryOver = 1;
        for(int i = digits.length-1; i >= 0; i--){
            if(carryOver + digits[i] == 10){
                digits[i] = 0;
                carryOver = 1;
            }
            else{
                digits[i]++;
                return digits;
            }
        }
        int[] ans = new int[digits.length+1];
        ans[0] = 1;
        return ans;
    }
}
