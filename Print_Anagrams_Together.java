import java.util.*;


class Solution {
    public List<List<String>> Anagrams(String[] string_list) {
        // Code here
        int size = string_list.length;
        
        TreeMap<String,List<String>>mp = new TreeMap<>();
        
        for(int i=0;i<size;i++){
            char[] charArray = string_list[i].toCharArray();
            Arrays.sort(charArray);
            String  temp = new String(charArray);
           
           if(!mp.containsKey(temp)){
               mp.put(temp,new ArrayList<String>());
           }
           
           mp.get(temp).add(string_list[i]);
            
        }
        
        List<List<String>> ans = new ArrayList<>();
         
        for(String cur:mp.keySet()){
          
            ans.add(mp.get(cur));
        }
        
        return ans;
    }
}