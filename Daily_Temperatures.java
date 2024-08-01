class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int len=temp.length;
        Stack<Integer> st=new Stack<>();
        int[] ans=new int[len];
        
        for(int i=len-1;i>=0;i--){
            while(!st.isEmpty() && temp[i]>=temp[st.peek()]){
                st.pop();
            }
            if(!st.isEmpty()){
                ans[i]=st.peek()-i;
            }
            st.push(i);
        }
        return ans;
        
    }
}