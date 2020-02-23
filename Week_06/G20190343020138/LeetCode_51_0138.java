class Solution {
    boolean[] col;
    boolean[] pie;
    boolean[] na;
    List<List<String>> res;
    char[] rowArray;

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<List<String>>(n);
        if(n<=0) return res;
        rowArray = new char[n];
        Arrays.fill(rowArray,'.');
        //修改为数据降低内存消耗
        col = new boolean[n];
        pie = new boolean[2*n];
        na = new boolean[2*n];

        dfs(n,0,new ArrayList<String>(n));
        return res;
    }

    private void dfs(int n,int row,List<String> list){
        //termin
        if(n==row){
            // res.add(list);
            // 此处的这行需要把list重新赋值给一个新对象
            res.add(new ArrayList<String>(list));
            return;
        }
        //本层逻辑
        for(int i = 0 ;i < n ;i ++){
            if(col[i]) continue;
            if(pie[i+row]) continue; 
            // if(na[i-row]) continue;
            if(na[row-i+n-1]) continue;

            //drill down
            rowArray[i]='Q';
            // String rowString = new String(charArray);
            list.add(new String(rowArray));
            rowArray[i]='.';
            col[i]=true;
            pie[i+row]=true;
            na[row-i+n-1]=true;
            
            dfs(n,row+1,list);
            
            //re state
            list.remove(list.size()-1);
            col[i]=false;
            pie[i+row]=false;
            na[row-i+n-1]=false;
        }
    }
}
