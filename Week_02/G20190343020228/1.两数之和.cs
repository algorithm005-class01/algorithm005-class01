public class Solution
{
    public int[] TwoSum(int[] nums, int target)
    {
        Hashtable table = new Hashtable();
        for (int i = 0; i < nums.Length; i++)
        {
            int goal = target - nums[i];
            if(table.ContainsKey(goal))
            {
                return new int[]{(int)table[goal],i};
            }
            else if(!table.ContainsKey(nums[i]))
            {
                table.Add(nums[i],i);
            }
        }

        return null;
    }
    public int[] TwoSumDic(int[] nums, int target)
    {
       Dictionary<int,int> dic = new Dictionary<int, int>();
       for (int i = 0; i < nums.Length; i++)
       {
           int j = target-nums[i];
           if(dic.ContainsKey(j))
           {
               return new int[]{dic[j],i};
           }
           else if(!dic.ContainsKey(nums[i]))
           {
                dic.Add(nums[i],i);
           }
       }
       return null;
    }
    public int[] TwoSum1(int[] nums, int target)
    {
        int[] rstLst = new int[2];
        if (nums == null || nums.Length < 2)
        {
            return rstLst;
        }

        int[] newLst = new int[nums.Length];
        for (int i = 0; i < nums.Length; i++)
        {
            newLst[i] = nums[i];
        }

        Array.Sort(newLst);
        int idx1 = 0;
        int idx2 = newLst.Length - 1;

        while (idx1 != idx2)
        {
            if (newLst[idx1] + newLst[idx2] > target)
            {
                idx2--;
            }
            else if (newLst[idx1] + newLst[idx2] < target)
            {
                idx1++;
            }
            else
            {
                break;
            }
        }

        rstLst[0] = -1;
        rstLst[1] = -1;
        for (int i = 0; i < nums.Length; i++)
        {
            if (nums[i] == newLst[idx1] || nums[i] == newLst[idx2])
            {
                if (rstLst[0] == -1)
                {
                    rstLst[0] = i;
                }
                else
                {
                    rstLst[1] = i;
                    break;
                }
            }
        }

        return rstLst;
    }
}