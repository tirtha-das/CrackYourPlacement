class Solution {
    public String reverseWords(String s) {
        Stack<String>st = new Stack<>();
       StringBuilder temp = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                if(temp.length()>0){
                    st.push(temp.toString());
                    temp.setLength(0);
                }
            }else{
                temp.append(s.charAt(i));
            }
        }

        if(temp.length()==0 && st.size()>0){
            temp.append(st.pop());
           // st.pop();
        }

        while(st.size()>0){
            temp.append(" ");
            temp.append(st.pop());
        }

        return temp.toString();
    }
}