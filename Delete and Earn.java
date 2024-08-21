class Solution {
    public int deleteAndEarn(int[] nums) {
      int[] count = new int[10001];
      int maxi = 0;
      for (int num : nums) {
        count[num] += num;
        maxi = Math.max(maxi, num);
      }
      int prev2=count[0],prev=count[1];
      for (int i = 2; i < maxi + 1; i++) {
        int curr=Math.max(prev,count[i]+prev2);
        prev2=prev;
        prev=curr;
      }
     
      return prev;
    }
  }