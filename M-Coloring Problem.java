class solve {
   public boolean isSafe(int c,int ind,boolean graph[][],int color[]){
        for(int i = 0;i<graph[ind].length;i++){
            if(graph[ind][i]){
                if(color[i] == c){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean helper(int ind,int color[],boolean graph[][],int m,int n){
        if(ind == n) return true;
        for(int j = 1;j<=m;j++){
            if(isSafe(j,ind,graph,color) && color[ind] == 0){
                color[ind] = j;
                if(helper(ind+1,color,graph,m,n) == true) return true;
                color[ind] = 0;
            }
        }
        return false; 
    }
    public boolean graphColoring(boolean graph[][], int m, int n) {
       int color[] = new int[n];
        return helper(0,color,graph,m,n);
    }
}