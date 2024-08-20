import java.util.*;


class Solution {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
      
   HashSet<Integer> set = new HashSet<>();
   int [] visited = new int[V+1] ;
    for(int i = 0;i< V ;i++){
        if(visited[i] == 0)
         if(fun(adj,i,visited,set))return true;
    }
      return false;
       
   }
   
   boolean fun(ArrayList<ArrayList<Integer>> adj ,int index,int[] visited , HashSet<Integer> set ){
      
      visited[index] = 1;
      set.add(index) ;
      
       for(int i =0 ; i< adj.get(index).size() ;i++){
           if(visited[adj.get(index).get(i)]==0){
               if(fun( adj , adj.get(index).get(i),visited,set)) return true;
           }
           else{
             if(set.contains(adj.get(index).get(i))) return true;  
           }
       }
       set.remove(index);
       return false;
   }
}