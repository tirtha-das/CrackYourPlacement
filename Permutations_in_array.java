import java.util.*;

class Solution {
    public boolean isPossible(int k ,int a[], int b[]) {
       Arrays.sort(a);
        Arrays.sort(b);
       
        int n = a.length;
        for(int i=0; i<n; i++){
            if(a[i] + b[n-1-i] < k){
               return false;
            }
        }
        return true;
    }
    
}