public class LeetCode_151_0120 {
    public String reverseWords(String s) {
        String str = new StringBuffer(s).reverse().toString();
        StringBuilder sb = new StringBuilder();
        String[] arr = str.split(" +");
        for(String temp:arr){
            String s1 = new StringBuffer(temp).reverse().toString();
            sb.append(s1+" ");
        }
        return sb.toString().trim();
    }
}
