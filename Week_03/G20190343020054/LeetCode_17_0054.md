# 17. 电话号码的字母组合

## 解题思路

### 1.回溯

```java
class Solution {
	  String[] letter_map = {" ","*","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	  public List<String> letterCombinations(String digits) {
        if(digits==null || digits.length()==0) {
            return new ArrayList<>();
        }
        iterStr(digits, "", 0);
        return res;
    }
	  List<String> res = new ArrayList<>();

	  void iterStr(String str, String letter, int index) {
        if(index == str.length()) {
          res.add(letter);
          return;
        }
        char c = str.charAt(index);
        int pos = c - '0';
        String map_string = letter_map[pos];
        for(int i=0;i<map_string.length();i++) {
          iterStr(str, letter+map_string.charAt(i), index+1);
        }
  	}
}

```

### 2.

```java
public List<String> letterCombinations(String digits) {
		LinkedList<String> ans = new LinkedList<String>();
		if(digits.isEmpty()) return ans;
		String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		ans.add("");
		for(int i =0; i<digits.length();i++){
			int x = Character.getNumericValue(digits.charAt(i));
			while(ans.peek().length()==i){
				String t = ans.remove();
				for(char s : mapping[x].toCharArray())
					ans.add(t+s);
			}
		}
		return ans;
	}
```