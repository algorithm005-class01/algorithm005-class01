import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Leecode_17_0116 {
    private  Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    private List<String> res = new ArrayList<String>();

    public List<String> letterCombinations(String digits) {
        search("",digits,0 ,res,phone);
        return res;
    }

    private void search(String s, String digits, int i, List<String> res, Map<String,String> phone) {

        if( i ==  digits.length()){
            res.add(s);
            return ;
        }

        String letter =  phone.get(digits.charAt(i));
        for( int j = 0 ; j < letter.length() ; j++){
            search(s+ letter.charAt(j) ,digits,i+1,res,phone);
        }

    }
}