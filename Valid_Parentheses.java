class Solution {
    public boolean isValid(String s) {
       
        Map<Character, Character> mp = new HashMap<Character, Character>();
        mp.put(')','(');
        mp.put('}','{');
        mp.put(']','[');
       
        Stack<Character> st = new Stack<>();
        
        for (int i=0;i<s.length();i++){
            
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                st.push(s.charAt(i));
                continue;
            }
            
            if (st.size() == 0 || mp.get(s.charAt(i)) != st.pop()) {
                return false;
            }
        }
       
        if (st.size() == 0) {
            return true;
        }
        else return false;
    
  }
}