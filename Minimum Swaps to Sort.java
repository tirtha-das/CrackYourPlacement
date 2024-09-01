import java.util.*;

class Solution
{
   public int minSwaps(int nums[])
    {
        int[] copy = new int[nums.length];
        for(int i=0;i<nums.length;i++) copy[i] = nums[i];
        Arrays.sort(copy);
        
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i=0;i<copy.length;i++){
            map.put(copy[i],i);
        }
        
        int swap = 0;
        
        for(int i=0;i<nums.length;i++){
            while(map.get(nums[i])!=i){
                int tem = nums[i];
                nums[i] = nums[map.get(nums[i])];
                nums[map.get(tem)] = tem;
                swap++;
                
            }
        }
        
        return swap;
    }
}