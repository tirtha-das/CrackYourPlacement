import java.util.*;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            
            if (tokens[i].equals("+")){
            
                stack.push(stack.pop()+stack.pop());
                
            }
            else if (tokens[i].equals("-")){
                int a = stack.pop();
                int b = stack.pop();
                int num = b-a;
                stack.push(num);
            }else if (tokens[i].equals("*")){
            
                stack.push(stack.pop()*stack.pop());
                
            }else if (tokens[i].equals("/")){
                int a = stack.pop();
                int b = stack.pop();
                int num = b/a;
                stack.push(num);
            }
            else
                stack.push(Integer.valueOf(tokens[i]));
            
        }
      return stack.peek();
    }
}