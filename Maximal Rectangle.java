import java.util.*;

class Solution {
    int largestRectangleArea(int[] heights) {
       Stack<Integer> st = new Stack<>();
       int maxArea = 0;

       for (int i = 0; i < heights.length; i++) {
           while (!st.isEmpty() && heights[st.peek()] > heights[i]) {
               int element = st.pop();
               int nse = i;
               int pse = st.isEmpty() ? -1 : st.peek();

               maxArea = Math.max(heights[element] * (nse - pse - 1), maxArea);
           }
           st.push(i);
       }

       while (!st.isEmpty()) {
           int element = st.pop();
           int nse = heights.length;
           int pse = st.isEmpty() ? -1 : st.peek();

           maxArea = Math.max(heights[element] * (nse - pse - 1), maxArea);
       }

       return maxArea;
   }

   public int maximalRectangle(char[][] matrix) {
       if (matrix.length == 0)
           return 0;

       int n = matrix.length;
       int m = matrix[0].length;

       int[][] prefixSumMatrix = new int[n][m];
       int maxArea = 0;

       for (int j = 0; j < m; j++) {
           int sum = 0;
           for (int i = 0; i < n; i++) {
               sum = (matrix[i][j] == '1') ? sum + 1 : 0;
               prefixSumMatrix[i][j] = sum;
           }
       }

       for (int i = 0; i < n; i++) {
           int[] row = prefixSumMatrix[i];
           maxArea = Math.max(maxArea, largestRectangleArea(row));
       }

       return maxArea;
   }
}