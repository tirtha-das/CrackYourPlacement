import java.util.*;

class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        List<Long> list = new ArrayList<>();
        list.add(0l);
        Long[] presum = new Long[n];
        Long acc = 0l;
        for(int i = 0;i<n;i++){
            acc += nums[i];
            presum[i] = acc;
        }
        
        int res = 0;
        for(int i = 0;i<n;i++){
            Long pre = presum[i];
            Long lowerbound = Long.valueOf(lower) - pre;
            Long upperbound = Long.valueOf(upper) - pre;
            int left = findMin(list,lowerbound);
            int right = findMax(list,upperbound);
            if(right >= left && list.get(0) <= upperbound && list.get(list.size()-1) >= lowerbound ) res += (right - left + 1);
            int insert = Collections.binarySearch(list,-pre);
            insert = insert < 0 ? (-insert-1) : insert;
            list.add(insert,-pre);
        }
        return res; 
    }
    
    public int findMin(List<Long> list, Long target){
        int left =0;
        int right = list.size()-1;
        while(left<right){
            int mid = (left + right)>>>1;
            if(list.get(mid) < target){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left;
    }
    
    public int findMax(List<Long> list, Long target){
        int left =0;
        int right = list.size()-1;
        while(left<right){
            int mid = (left + right + 1)>>>1;
            if(list.get(mid) > target){
                right = mid - 1;
            }else{
                left = mid;
            }
        }
        return left;
    }
}