public List<String> letterCombinations(String digits) {

        List<String>list=new ArrayList<>();
        String []s=new String[digits.length()];
        int M=digits.length();
        if(s.length==0){
            return list;
        }
        for(int i=0;i<digits.length();i++){
            switch (digits.charAt(i)){
                case '2':s[i]="abc";break;
                case '3':s[i]="def";break;
                case '4':s[i]="ghi";break;
                case '5':s[i]="jkl";break;
                case '6':s[i]="mno";break;
                case '7':s[i]="pqrs";break;
                case '8':s[i]="tuv";break;
                case '9':s[i]="wxyz";break;
            }
        }
        list=getStringWithFor(s,0,list,"");
        return list;
    }

    private static List<String> getStringWithFor(String []s,int i,List<String> list,String stemp) {

            if(i<s.length-1){
                for(int j=0;j<s[i].length();j++){
                    list=getStringWithFor(s,i+1,list,stemp+s[i].charAt(j));
                }
                i++;
            } else {
                for(int j=0;j<s[i].length();j++){
                    list.add(stemp+s[i].charAt(j));
                }
            }

            return list;
        }