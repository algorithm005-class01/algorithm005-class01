bool isAnagram(char * s, char * t){
    int n=strlen(s),m=strlen(t);
    if(n != m)
        return false;

    int key[26] = {0};

    for(int i=0;i<n;i++)
    {
        key[s[i]-'a']++;
        key[t[i]-'a']--;       
    }
    for(int i=0;i<26;i++)
    {
        if(key[i] != 0)
            return false;
    }

    return true;
}