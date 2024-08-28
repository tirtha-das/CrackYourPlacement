import java.util.*;

class Solution{   
    static boolean used[];
    public boolean isKPartitionPossible(int a[], int n, int k)
    {
        int sum = 0;
        for(int i=0;i<n;i++) sum +=a[i];
        if(sum%k!=0) return false;
        used = new boolean[n];
        Arrays.sort(a);
        int i1=0, j= n-1;
        while(i1<j) {
            int t = a[i1];
            a[i1] = a[j];
            a[j] = t;
            i1++;
            j--;
        }
        //System.out.println(Arrays.toString(a));
        boolean val = true;
        for(int i=0;i<k;i++) {
            val = val && isDoable(a, 0, sum/k, 0);
            //System.out.println(Arrays.toString(used));
        }
	    return val;
    }
    
    boolean isDoable(int a[], int sum, int div, int i) {
        if(sum==div) {
            return true;
        }
        if(i==a.length) return false;
        boolean splitted = false;
        if(!used[i] && sum+a[i]<=div) {
               used[i] = true;
               boolean sp1 = isDoable(a, sum+a[i], div, i+1);
               if(sp1) return true;
               used[i] = false;
               splitted = splitted || sp1 || isDoable(a, sum, div, i+1) ; 
               if(splitted) {
                   return true;
               }
            } else {
                splitted = splitted ||isDoable(a, sum, div, i+1); 
            }
        return splitted;
    }
}