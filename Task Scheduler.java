import java.util.*;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int arr[] = new int[26];
        for(int i=0; i<tasks.length; i++){
            arr[tasks[i]-'A']++;
        }

        Arrays.sort(arr);
        int max = arr[25]-1;
        int slots = max*n;

        for(int i=24; i>=0; i--){
            slots = slots-Math.min(max,arr[i]);
        }
        return slots>0 ? tasks.length+slots : tasks.length;
    }
}