class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        int n = nums.length;

        Map<Integer,Integer> map = new HashMap<>();

        for(int i =0 ;i<n;i++){
            int a = nums[i];

            int b = target-a;

            if(map.containsKey(b)){
                res[0]=map.get(b);
                res[1]=i;
            }
            map.put(a,i);
        }
        return res;
    }
}