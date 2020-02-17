class Solution {
public:
    int longestCommonSubsequence(string text1, string text2) {
        int l1=text1.size(),l2=text2.size();
	int dp[l2+1],last=0,temp;
	fill(dp,dp+l2+1,0);
        for(int i=1;i<=l1;++i,last=0){
		for(int j=1;j<=l2;++j){
            	   temp=dp[j];
		   if(text1[i-1]==text2[j-1])	dp[j]=last+1; 
		   else	 dp[j]=max(dp[j],dp[j-1]);
        	   last=temp;
		}
        }
	return dp[l2];
    }
};
