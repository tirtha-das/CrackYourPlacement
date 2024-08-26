import java.util.*;



class Solution {
    static boolean dfs(int node,int[] visited, int[] pathvisited, ArrayList<ArrayList<Integer>> adj)
    {
        visited[node]=1;
        pathvisited[node]=1;
        for(Integer neighbor:adj.get(node))
        {
            if(visited[neighbor]==0)
            {
                if(dfs(neighbor,visited,pathvisited,adj))
                    return true;
            }
            else if(pathvisited[neighbor]==1)
                return true;
        }
        pathvisited[node]=0;
        return false;
    }
    public boolean isPossible(int n,int P, int[][] prerequisites)
    {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
       for(int i=0;i<n;i++)
       {
           adj.add(new ArrayList<>());
       }
        for(int i=0;i<P;i++)
        {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int visited[]=new int[n];
        int pathvisited[]=new int[n];
       for(int i=0;i<n;i++)
       {
           if(visited[i]==0)
           {
               if(dfs(i,visited,pathvisited,adj))
                    return false;
           }
       }
       return true;
    }
    
}