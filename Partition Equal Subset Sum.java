import java.util.*;

class Solution{
    
    public static void helper(int[] arr,int i, int sum, int cursum,List<Integer> ans) {
        
        if(i == arr.length) {
            if(sum == cursum) {
                ans.set(0,1);
            }
            return;
        }
        
        if(ans.get(0) == 1) return;
        
        if(sum < cursum) return;
        
        
        
        
        helper(arr,i + 1,sum - arr[i],cursum + arr[i],ans);
        
        
        helper(arr,i + 1,sum,cursum,ans);
    }
    
    
    static int equalPartition(int N, int arr[])
    {
        // code here
        if(N == 0) return 0;
        
        int sum = 0;
        for(int i = 0; i < N; i++) {
            sum += arr[i];
        }
        if(sum%2 != 0) return 0;
        List<Integer> ans = new ArrayList<>();
        ans.add(0);
        
        helper(arr,0,sum,0,ans);
        return ans.get(0);
    }
}
   