import java.util.*;

class Solution {
    public int minDeletions(String s) {
        if(s.length() == 0) return  0 ;
            
        int[] arr = new int[26] ;
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i) ;
            arr[ch - 'a'] ++ ;
        }
        HashSet<Integer> mp = new HashSet<>() ;
        int count = 0 ;
        for(int i = 0 ; i < 26 ; i++){
            int f = arr[i] ;
            
            if(! mp.contains(f) )
                mp.add(f) ;
            else{
                while(f > 0 &&  mp.contains(f) ){
                    f -- ;
                    count ++ ;
                }
                mp.add(f) ;
            }
        }
        return count ;
    }
}