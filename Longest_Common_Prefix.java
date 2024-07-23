class Solution {
    public String longestCommonPrefix(String[] strs) {
       int idx = 0;
        int size = strs[0].length();

        for(int i=1;i<strs.length;i++){
            if(size>strs[i].length()){
                idx = i;
                size = strs[i].length();
            }
        }

        String ans = "";
        for(int i=1;i<=size;i++){
            String sub = strs[idx].substring(0,i);
           // System.out.println(sub);
            int check = 1;
            for(String it:strs){
                if(!it.substring(0,i).equals(sub)){
                    check=0;
                    break;
                }
            }
            if(check==1){
                    ans = sub;
                   // System.out.println("hello" + ans);

                }
                else{
                    break;
                }
        }

        return ans;


    }
}