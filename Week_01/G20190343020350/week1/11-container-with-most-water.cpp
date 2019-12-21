class Solution {
public:
    int maxArea(vector<int>& height) {
        int len = height.size();
        int area = 0, area_max = 0, l = 0, r = len - 1, last_h = 0;
        while(l < r)
        {
            int h = (height[l] < height[r]?height[l] : height[r]);
            if(last_h < h)
                area = h*(r - l);
            last_h = h;
            area_max = (area_max > area ? area_max: area);
            if (height[l] > height[r])
                r--;
            else
                l++;
        }
        return area_max;
    }
};
