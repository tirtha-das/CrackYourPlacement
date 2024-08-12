import java.util.*;

class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length()==k){
            String ans = "0";
            return ans;
        }

        Stack<Character>st = new Stack<>();


        for(int i=0;i<num.length();i++){
           while(st.size()>0 && st.peek()>num.charAt(i) && k>0){
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }

        while(k>0){
            st.pop();
            k--;
        }

        StringBuilder ans = new StringBuilder("");

        while(st.size()>0){
            ans.append(st.pop());
        }

        ans.reverse();

        String res = ans.toString();

        int zeros = -1;

        for(int i=0;i<res.length();i++){
            if(res.charAt(i)!='0') break;

            zeros = i; 
        }
       
       String res1 = res.substring(zeros+1);
       String res2 = new String("0");

       if(res1.length()>0) return res1;
       else return res2;
      
    }
}