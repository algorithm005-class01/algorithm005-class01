public class Solution {
	public String reverseWords(String s) {
	   String emptyStr = " ";
		String []splits = s.trim().split(emptyStr);
		StringBuilder sb=new StringBuilder();
		sb.append(splits[splits.length-1]);
		for(int i=splits.length-2;i>=0;i--){
			if (!splits[i].isEmpty()) {
				sb.append(emptyStr);
				sb.append(splits[i]);
			}
			
		}

		return sb.toString();

	}
}