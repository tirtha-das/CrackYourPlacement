class Solution {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        long ans = Integer.MIN_VALUE;
        long mod = Integer.MAX_VALUE;

       long pref = 1,suf = 1;


    for(int idx = 0;idx<len;idx++){
          
        if(pref==0) pref=1;
        if(suf==0) suf = 1;

          pref*=nums[idx];
          pref%=mod;
          suf *=nums[len-idx-1];
          suf%=mod;
           ans = Math.max(ans,Math.max(pref,suf));
        }
     
     // System.out.printf("%d",dp[0]);

     return (int)ans;

    }

    
}