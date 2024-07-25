class Solution 
{
    public int maximumProduct(int[] nums) 
    {
        // Initialize Maximum, second maximum
        // and third maximum element
        int maxA=Integer.MIN_VALUE;
        int maxB=Integer.MIN_VALUE;
        int maxC=Integer.MIN_VALUE;

        // Initialize Minimum and
        // second minimum element
        int minA=Integer.MAX_VALUE;
        int minB=Integer.MAX_VALUE;
        
        for(int i=0;i<nums.length;i++)
        {
            // Update Maximum, second maximum
            // and third maximum element
            if(nums[i]>maxA)
            {
                maxC=maxB;
                maxB=maxA;
                maxA=nums[i];
            }

            // Update second maximum and
            // third maximum element
            else if(nums[i]>maxB)
            {
                maxC=maxB;
                maxB=nums[i];
            }

            // Update third maximum element
            else if(nums[i]>maxC)
            {
                maxC=nums[i];
            }

            // Update Minimum and second
            // minimum element
            if(nums[i]<minA)
            {
                minB=minA;
                minA=nums[i];
            }

            // Update second minimum element
            else if(nums[i]<minB)
            {
                minB=nums[i];
            }
        }
        return Math.max(maxA*maxB*maxC,minA*minB*maxA);
    }
}