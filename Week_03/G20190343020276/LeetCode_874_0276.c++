class Solution {
public:
    int robotSim(vector<int>& commands, vector<vector<int>>& obstacles) {

        int dx[4] = {0,1,0,-1};
        int dy[4] = {1,0,-1,0};
        int x = 0,y = 0,di = 0;//记录位置和方向

        //故障点用集合存储
        set<pair<int, int>> obstacleSet;  
        for (vector<int> obstacle: obstacles)
            obstacleSet.insert(make_pair(obstacle[0], obstacle[1]));

        int ans = 0;
        for(int command:commands)
        {
            if(command == -2)//左转90度
            {
                di = (di + 3)%4;
            }
            else if(command == -1)//右转90度
            {
                di = (di + 1)%4;
            }
            else
            {
                for(int k=0;k<command;k++)
                {
                    int nextX = dx[di] + x;
                    int nextY = dy[di] + y;

                    if(obstacleSet.find(make_pair(nextX,nextY)) == obstacleSet.end())
                    {
                        x = nextX;
                        y = nextY;
                        ans = max(ans,x*x+y*y);
                    }
                }
            }
        }
        return ans;
        
    }
};
