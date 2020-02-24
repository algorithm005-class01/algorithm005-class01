class Solution {
public:
	int maxProfit(vector<int>& prices) {
		int num=0;
		vector<int>::iterator iter2=prices.begin();
		for(vector<int>::iterator iter1=prices.begin();iter1!=prices.end();iter1++){        
			if(*iter1>*iter2){
				num+=*iter1-*iter2;
			}
			*iter2=*iter1;
		}
	return num;    
  }
};