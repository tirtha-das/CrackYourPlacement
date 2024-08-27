import java.util.*;

class Solution {
    public int makeConnected(int n, int[][] connections) {
        int clusters = 0;
        boolean visited[] = new boolean[n];
        boolean isConnected[] = new boolean[n];
        int extraWires = 0;

        List<Integer> adj[] = new ArrayList[n];
        for(int i=0;i<n;i++)
            adj[i] = new ArrayList<>();
        
        for(int arr[] : connections){
            adj[arr[0]].add(arr[1]);
            adj[arr[1]].add(arr[0]);

            if(isConnected[arr[0]] && isConnected[arr[1]])
                extraWires++;
            else{
                isConnected[arr[0]] = true;
                isConnected[arr[1]] = true;
            }
        }

        for(int i=0;i<n;i++){
            if(!visited[i]){
                clusters++;
                dfs(adj,n,i,visited);
            }
        }

        System.out.println(clusters);
        if(extraWires >= clusters-1)
            return clusters-1;
        return -1;
    }

    static void dfs(List<Integer> adj[],int n,int src,boolean visited[]){
        if(src >= n)
            return;
        
        if(visited[src])
            return;
        
        visited[src] = true;

        for(int i=0;i<adj[src].size();i++)
            dfs(adj,n,adj[src].get(i),visited);
    }
}