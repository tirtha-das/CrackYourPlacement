import java.util.*;




class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int sol = 0;
        int[][] vis = new int[m][n];
        for (int r=0;r<m;r++)
        {
            for (int c=0;c<n;c++)
            {
                if(grid[r][c]=='1' && vis[r][c]==0)
                {
                    sol++;
                    bfs(r,c,vis,grid);
                }
            }
        }
        return sol;
    }
    public void bfs(int r,int c,int[][] vis,char[][] grid)
    {
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        vis[r][c]=1;
        q.add(new Pair(r,c));
        int[] arow={-1,0,0,1};
        int[] acol={0,-1,+1,0};
        while(!q.isEmpty())
        {
            int row=q.peek().r;
            int col=q.peek().c;
            q.remove();
            for (int i=0;i<arow.length;i++)
            {
                int row1=row+arow[i];
                int col1=col+acol[i];
                if(row1>=0 && row1<m && col1>=0 && col1<n && 
                grid[row1][col1]=='1' && vis[row1][col1]==0)
                {
                    q.add(new Pair(row1,col1));
                    vis[row1][col1]=1;
                }
            }
        }
    }
}
class Pair
{
    int r;
    int c;
    Pair(int r,int c)
    {
        this.r=r;
        this.c=c;
    }
}