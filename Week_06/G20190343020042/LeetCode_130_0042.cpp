class Solution {
public:
     void dfs(vector<vector<char>>& board,int i,int j){
        if(i>=0&&i<board.size()&&j>=0&&j<board[0].size()&&board[i][j]=='O'){
            board[i][j]='1';
            dfs(board,i-1,j);
            dfs(board,i+1,j);
            dfs(board,i,j-1);
            dfs(board,i,j+1);
        }
     }
    void solve(vector<vector<char>>& board) {
        if(board.size()==0){
            return;
        }
        int rows=board.size(),cols=board[0].size();
        for(int i=0;i<rows;i++){
            dfs(board,i,0);
            dfs(board,i,cols-1);
        }
        for(int j=1;j<cols-1;j++){
            dfs(board,0,j);
            dfs(board,rows-1,j);
        }
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(board[i][j]=='1'){
                    board[i][j]='O';
                }
                else{
                    board[i][j]='X';
                }
            }
        }
    }

   
};