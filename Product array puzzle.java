class Solution {
    public static long[] productExceptSelf(int nums[]) {
        // code here
        int n=nums.length;
        long productArray[]=new long[n];
        long product=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j){
                    continue;
                }
                else{
                    product*=nums[j];
                }
            }
            productArray[i]=product;
            product=1;
        }
        return productArray;
        
    }
}