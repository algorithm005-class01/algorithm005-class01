char * reverseOnlyLetters(char * S){

    if(S == NULL)
    {
        return S;
    }
    int left = 0;
    int right = strlen(S);
    while(left<=right)
    {
        char temp;
        if(!((S[left]>='a'&&S[left]<='z')||(S[left]>='A'&&S[left]<='Z')))
        {
            left++;
            continue;
        }
        if(!((S[right]>='a'&&S[right]<='z')||(S[right]>='A'&&S[right]<='Z')))
        {
            right--;
            continue;
        }  
        temp = S[left];
        S[left] = S[right]; 
        S[right] = temp;   
        left++;
        right--;  
    }
    return S;
}