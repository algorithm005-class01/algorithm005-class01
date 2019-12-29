char ** letterCombinations(char * digits, int* returnSize){

    *returnSize = 0;
    char **char_str = NULL;
    if((digits == NULL) || (digits[0] == '\0'))
    {
        return char_str;
    }
    char *hashmap[8] = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    char hasmap_leng[8] = {3,3,3,3,3,4,3,4};
    char str_size=strlen(digits);
    int i = 0,j = 0,k = 0,l= 0;
    int tree_level = 1;
    int numsize = 0;

    while(i<str_size)
        tree_level *= hasmap_leng[digits[i++] - '2'];

    numsize = *returnSize = tree_level;
    char_str = (char**)malloc(sizeof(char**)*tree_level+1);
    i = 0;
    while(i<tree_level)
    {
        char_str[i] = (char*)malloc(sizeof(char)*str_size+1);
        memset(char_str[i],0,sizeof(char)*str_size+1);
        i++;
    }

    i = 0;
    while(i<str_size)
    {
        if(digits[i] == '7' || digits[i] == '9')
        {
            tree_level /= 4;
        }
        else
        {
            tree_level /= 3;
        }
        while(j<numsize)
        {
            while(k<tree_level)
            {
              char_str[j+k][i]= hashmap[digits[i]-'2'][l];
              k++;
            }
            j+=k;
            k=0;

            if(l<hasmap_leng[digits[i]-'2']-1)
                l++;
            else
                l = 0;
        }
        j = 0;
        l = 0;
        i++;
    }


 

    return char_str;
}

