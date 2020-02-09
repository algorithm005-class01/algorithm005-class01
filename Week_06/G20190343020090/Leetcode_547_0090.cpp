class Solution {
public:
    int findCircleNum(vector<vector<int>>& M) {
        vector<int> parent(M.size(), -1);

        for( int i = 0; i < M.size(); i++)
        {
            for(int j = 0; j < M.size(); j++)
            {
                if (M[i][j] == 1 && i != j)
                {
                    _union(parent, i, j);
                }
            }
        }

        int count = 0;
        for (int i = 0; i < parent.size(); i++)
        {
            if (parent[i] == -1)
                count++;
        }
        
        return count;
    }

    int find(vector<int>& parent, int i)
    {
        if(parent[i] == -1)
            return i;
        return find(parent, parent[i]);
    }

    void _union(vector<int>& parent, int x, int y)
    {
        int xset = find(parent, x);
        int yset = find(parent, y);
        if (xset != yset)
            parent[xset] = yset;
    }
};