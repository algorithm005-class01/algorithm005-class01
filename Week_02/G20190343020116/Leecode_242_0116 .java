import java.util.HashMap;
import java.util.Map;

class Leecode_242_0116 {
    public boolean isAnagram(String s, String t) {
        //遍历字符串，往map中添加数据
        char[] sh = s.toCharArray();
        char[] th = t.toCharArray();
        //创建两个map
        Map<Integer,Integer> maps =new HashMap<Integer,Integer>();
        Map<Integer,Integer> mapt =new HashMap<Integer,Integer>();
        for(int i=0;i <sh.length;i++){
            if(maps.containsKey((int)sh[i])){
                maps.put((int)sh[i],maps.get((int)sh[i])+1);
            }else{
                maps.put((int)sh[i],1);
            }
        }
        for(int j =0;j <th.length;j++){
            if(mapt.containsKey((int)th[j])){
                mapt.put((int)th[j],mapt.get((int)th[j])+1);
            }else{
                mapt.put((int)th[j],1);
            }

        }
        //比较两个map是不是相同
        if(maps.equals(mapt)){
            return true;
        }else{
            return false;
        }


    }
}