void reverse(char *s,int lelf,int right)
{
    while(lelf<right)
    {
        int temp = s[lelf];
        s[lelf]=s[right];
        s[right]=temp;

        lelf++;
        right--;
    }
}

char * reverseStr(char * s, int k){
    int s_size = strlen(s);
    for(int i = 0;i<s_size;i+=2*k)
    {
        if((i+2*k<=s_size) || (i+k<=s_size))
            reverse(s,i,i+k-1);
        else
            reverse(s,i,s_size-1);
    }
    return s;
}