class Solution {
    public int findContentChildren(int[] children, int[] cookies) {
        Arrays.sort(children);
        Arrays.sort(cookies);
        int j = 0;
        for (int i = 0; i < cookies.length && j < children.length; ++i)
            if (children[j] <= cookies[i]) ++ j;
        return j;
    }
}