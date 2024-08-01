class Solution
{
    //Function to evaluate a postfix expression.
    public static int evaluatePostFix(String S)
    {
        // Your code here
        Stack<Integer> st = new Stack<>();
        for(char c:S.toCharArray()){
            if(Character.isDigit(c)){
                st.push(c - '0');
            }else if(c == '+' || c == '-' || c == '*' || c == '/'){
                int a = st.pop();
                int b= st.pop();
                switch(c){
                    case '+':
                        st.push(a+b);
                        break;
                    case '-':
                        st.push(b-a);
                        break;
                    case '*':
                        st.push(a*b);
                        break;
                    case '/':
                        st.push(b/a);
                        break;
                }
            }
        }
        return st.pop();
    }
}