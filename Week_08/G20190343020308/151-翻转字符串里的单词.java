    public String reverseWords(String s) {
        s = s.trim();
        if(s.equals("")) {
            return "";
        }
        String[] sp = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = sp.length - 1; i >= 0; i--) {
            sp[i].trim();
            if(sp[i].equals("")) {
                continue;
            }
            sb.append(sp[i]);
            sb.append(" ");
        }
        return sb.toString().substring(0, sb.length() - 1);
    }


