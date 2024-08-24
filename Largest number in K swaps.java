class Solution {
    void swap(char[] arr, int i, int j) {
         char temp = arr[i];
         arr[i] = arr[j];
         arr[j] = temp;
     }
 
      void helper(StringBuilder max, char[] str, int k, int idx) {
         if (k == 0 || idx == str.length) {
             return;
         }
 
         int maxChar = (int)str[idx];
         for (int i = idx + 1; i < str.length; i++) {
             if (maxChar < (int)str[i]) {
                 maxChar = str[i];
             }
         }
 
         if (maxChar != (int)str[idx]) {
             k--;
         }
 
         for (int i = idx; i < str.length; i++) {
             if ((int)str[i] == maxChar) {
                 swap(str, i, idx);
                 if (new String(str).compareTo(max.toString()) > 0) {
                     max.replace(0, max.length(), new String(str));
                 }
 
                 helper(max, str, k, idx + 1);
                 swap(str, i, idx); 
             }
         }
     }
 
     // Function to find the largest number after k swaps.
     public String findMaximumNum(String str, int k) {
         char[] arr = str.toCharArray();
         StringBuilder max = new StringBuilder(str);
         helper(max, arr, k, 0);
         return max.toString();
     }
 }