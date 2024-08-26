import java.util.*;

class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        int[] ans = new int[V];
        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < V; i++){
            if(!vis[i]){
                dfs(i, vis, st, adj);
            }
        }
        
        int i = 0;
        while(!st.empty()){
            ans[i] = st.pop();
            i++;
        }
        return ans;
    }
    
    static void dfs(int node, boolean[] vis, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj)
    {
        vis[node] = true;
        
        for(int nbr : adj.get(node)){
            if(!vis[nbr]){
                dfs(nbr, vis, st, adj);
            }
        }
        st.push(node);
    }
}