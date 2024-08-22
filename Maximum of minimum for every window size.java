import java.util.*;

class Solution 
{
    //Function to find maximum of minimums of every window size.
    static int[] maxOfMin(int[] arr, int n) 
    {
        // Your code here
        Stack<Integer> st=new Stack<>();
        int left[]=new int[n];
        int right[]=new int[n];
        for(int i=0;i<n;i++){
            left[i]=-1;
            right[i]=n;
        }
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            
            if(!st.isEmpty()){
                left[i]=st.peek();
            }
            st.push(i);
        }
      
        
        while(!st.isEmpty()) st.pop();
        
        
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            
            if(!st.isEmpty()){
                right[i]=st.peek();
            }
            st.push(i);
        }
        
        
        int result[]=new int[n];
        for(int i=0;i<n;i++){
            result[i]=Integer.MIN_VALUE;
        }
        
        for(int i=0;i<n;i++){
            int len=right[i]-left[i]-1;
            result[len-1]=Math.max(result[len-1],arr[i]);
        }
        
        for(int i=n-2;i>=0;i--){
            result[i]=Math.max(result[i],result[i+1]);
        }
        return result;
         
        
    }
}