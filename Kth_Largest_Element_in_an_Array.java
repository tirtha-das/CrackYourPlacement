import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int num : nums)
            maxHeap.add(num);
        System.out.println(maxHeap);
        while(k > 1 ){
            maxHeap.remove();
            k--;
        }
        return maxHeap.remove();
    }
}