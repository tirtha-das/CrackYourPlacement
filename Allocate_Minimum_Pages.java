class Solution {
   
    public static long findPages(int n, int[] arr, int m) {
        // Your code here
         long sum = 0;
        if (n < m) return -1;
        for (int i = 0; i < n; i++) sum += arr[i];
        long l = 0;
        long h= sum;
        long res= (long)1e15;
        while(l<=h){
           long mid=(l+h)/2;
            if(isFeasible(n,arr,m,mid))
            {
            h=mid-1;
            res=Math.min(res,mid);
            }
            else
            {l=mid+1;}
        }
        return res;
    }
     public static boolean isFeasible
    (int n, int[] arr, int m, long curMin) {
        int studentsRequired = 1;
        long curSum = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > curMin) return false;
            if (curSum + arr[i] > curMin) {
                studentsRequired++;
                curSum = arr[i];
                if (studentsRequired > m) return false;
            } else {
                curSum += arr[i];
            }
        }
        return true;
    }
}