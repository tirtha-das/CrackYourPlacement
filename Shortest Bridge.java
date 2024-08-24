import java.util.*;

class Solution {
  public void dfs(int[][] grid,Queue<int[]> q, boolean [][]vis,int i,int j,int n){
    if (i<0||j<0||i>=n||j>=n||vis[i][j]||grid[i][j]==0)return ;

    vis[i][j]=true;
    q.add(new int[]{i,j});
    dfs(grid,q,vis,i+1, j, n);
    dfs(grid,q,vis,i-1, j, n);
    dfs(grid,q,vis,i, j+1, n);
    dfs(grid,q,vis,i, j-1, n);

  }
    public int shortestBridge(int[][] grid) {
      
        Queue<int[]> q = new LinkedList<>();
       
       int n=grid.length;
      boolean [][]vis=new boolean[n][n];

        for(int i=0;i<n;i++){
          for(int j=0;j<n;j++){
             if(grid[i][j]==1){
                dfs(grid,q,vis,i, j, n);
               break;
             }
          }
          if(!q.isEmpty())break;
        }
        int dir1[]={0,1,0,-1};
        int dir2[]={-1,0,1,0};
      int ans=0;
      while(!q.isEmpty()){
         int size=q.size();

       while(size!=0){
         int []a=q.poll();
         int x=a[0];
         int y=a[1];
           for(int i=0;i<4;i++){
              int newx=x+dir1[i];
              int newy=y+dir2[i];
               if (newx>=0 && newy>=0 && newx<n && newy<n && !vis[newx][newy]){
                  if(grid[newx][newy]==1) return ans;
                        q.add(new int[]{newx,newy});
                        vis[newx][newy]=true;
                 }
             }   
           size--;   
         }
         ans++;
       }
       return ans;
    }
}