
import java.util.*;

class GfG
{
    int maxLen(int arr[], int n)
    {
        // Your code here
        
        int maxi = 0;
        int sum = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        for(int i=0;i<n;i++)
        {
            sum = sum+arr[i];
            if(sum==0)
            maxi = i+1;
            else{
            if(hm.get(sum)!=null)
            {
                maxi = Math.max(maxi,i-hm.get(sum));
                
            }
            else
            {
                hm.put(sum,i);
            }
            }
        }
        return maxi;
    }
}