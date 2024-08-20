import java.util.*;


class Pair {
    int x;
    int y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Solution
{
    
    public boolean isSafe(int x, int y, int N, boolean[][] visit) 
    {
        if (x >= 1 && x <= N && y >= 1 && y <= N && !visit[x][y])
            return true;
        return false;
    }
    
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        
        int dx[] = { -2, -1, 1, 2, -2, -1, 1, 2 };
        int dy[] = { -1, -2, -2, -1, 1, 2, 2, 1 };
        
        int res = 0;
        
        Queue<Pair> q = new LinkedList<>();

        
        q.add(new Pair(KnightPos[0], KnightPos[1]));
        boolean visit[][] = new boolean[N+1][N+1];
        
        visit[KnightPos[0]][KnightPos[1]] = true;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                Pair pair = q.poll();
                if(pair.x == TargetPos[0] && pair.y == TargetPos[1]) {
                    return res;
                }
                for(int index = 0; index < 8; index++) {
                    int u = pair.x + dx[index];
                    int v = pair.y + dy[index];
                    if(isSafe(u,v, N, visit)) {
                        q.add(new Pair(u,v));
                        visit[u][v] = true;
                    }
                }
            }
             res++;
        }
        return res;
    }
}