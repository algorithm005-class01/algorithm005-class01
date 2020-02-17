class Solution {
    public String reverseWords(String s) {
        String[] words = s.split("\\s+");
        List<String> rwords = new ArrayList<>();
        for (int i = words.length - 1; i >= 0; i--) {
            if (words[i].length() > 0) {
                rwords.add(words[i]);
            }
        }
        return String.join(" ", rwords);
        
    }
}