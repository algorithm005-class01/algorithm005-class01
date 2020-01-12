class Solution {
    public int leastInterval(char[] tasks, int n) {
    	
    	if(n==0) return tasks.length;
    	
    	int ans=0;
        int[] a=new int[26];
        
        for(int i=0;i<tasks.length;i++)
        	a[tasks[i]-'A']++;
        
        Arrays.parallelSort(a);
        
        int max_val=a[25]-1,idle_slots=max_val*n;
        for(int i=24;i>=0 && a[i]>0;i--)
        	idle_slots-=Math.min(a[i], max_val);
        
        return idle_slots>0?idle_slots+tasks.length:tasks.length;
    }
}
