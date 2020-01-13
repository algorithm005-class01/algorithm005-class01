int cmpfunc (const void * a, const void * b)
{
   return ( *(int*)b - *(int*)a );
}

int leastInterval(char* tasks, int tasksSize, int n){
    int hash_map[26] ={0};
    for(int i = 0;i<tasksSize;i++)
    {
        hash_map[tasks[i]-'A']++;
    }
    qsort(hash_map,26,sizeof(int),cmpfunc);
    
    int max = hash_map[0];
    int maxnum = 0;
    for(int i = 0;i<26;i++)
    {
        if(hash_map[i] == max)
        {
           maxnum++; 
        }
        else 
            break;
    }
    int ret=(n+1 - maxnum)*(max -1)+max*maxnum;
    return ret > tasksSize? ret : tasksSize;
}