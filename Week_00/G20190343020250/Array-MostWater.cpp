class Solution {
public:
    int maxArea(vector<int>& height) {
        int i = 0,j = height.size() - 1;
        int TempS=0,TempMinHeight = 0,TempDistance = 0;
        int maxArea=0;
        TempDistance = height.size() - 1;
        while(i!=j)
        {       
            if(height[i]>height[j])
            {
                TempMinHeight = height[j];
                TempS = TempDistance * TempMinHeight; 
                j--;
            }
            else
            {
                TempMinHeight = height[i];
                TempS = TempDistance * TempMinHeight; 
                i++;
            }
            if(TempS>maxArea)
                maxArea = TempS;
            TempDistance--;
        }
        return maxArea;
    }
};