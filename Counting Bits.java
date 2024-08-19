class Solution {
    public int[] countBits(int n) {
        int[] arr = new int[n+1];
        int next = 1, j = 0;
        arr[0] = 0;

        for(int i = 1; i <= n; i++){
            if(i == next){ 
                next *= 2;
                j = 0; 
            }
            arr[i] = 1 + arr[j++];
        }
        return arr;
    }
}