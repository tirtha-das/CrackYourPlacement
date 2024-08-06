
import java.util.*;

class Solution {
    public int findPair(int n, int x, int[] arr) {
        
        HashSet<Integer> set=new HashSet<>();
        
      
        
        for(int i=0;i<arr.length;i++){
          if(set.contains(arr[i]-x)){
              return 1;
          }
          if(set.contains(arr[i]+x)){
              return 1;
          }
          set.add(arr[i]);
        }
        return -1;
        
    }
}