class Solution {
public:
	
 
	vector<string> letterCombinations(string digits) {
		unordered_map<char,string> mp{{'2',"abc"},{'3',"def"},{'4',"ghi"},{'5',"jkl"},
                                      {'6',"mno"},{'7',"pqrs"},{'8',"tuv"},{'9',"wxyz"}};
		vector<string> result{""};
		if(digits.size()==0) return {};
  	for(int i=0;i<digits.size();i++){
 			vector<string> temp;
    	string str = mp[digits[i]];
    	for(int j=0;j<str.size();j++){
    		for(string s:result) 
					temp.push_back(s+str[j]);
			}
			result = temp;
		}
  	return result;
	}
};