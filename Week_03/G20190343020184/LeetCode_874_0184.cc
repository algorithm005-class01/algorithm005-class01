#include <vector>
#include <set>
using namespace std;

class Solution {
public:
    int robotSim(vector<int>& commands, vector<vector<int>>& obstacles) {
        int res = 0;
        int dx[4] = {0, 1, 0, -1};
        int dy[4] = {1, 0, -1, 0};
        set<pair<int, int>> obs;
        for (auto ob : obstacles) {
            obs.insert(make_pair(ob[0], ob[1]));
        }
        int x = 0, y = 0;
        int d = 0;
        for (int command : commands) {
            if (command == -1) {
                d = (d + 1) % 4;
            } else if (command == -2) {
                d = (d + 3) % 4;
            } else {
                while (command--){
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if (obs.find(make_pair(nx, ny)) != obs.end()){
                        break;
                    }
                    x = nx;
                    y = ny;
                    res = max(res, x * x + y * y);
                }
            }
        }
        return res;
    }
};

int main(int argc, char *argv[])
{
	
	return 0;
}
