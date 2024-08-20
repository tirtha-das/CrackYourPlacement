import java.util.*;




class Solution {
    String dir = "DLRU";
    int[] dr={1, 0, 0, -1};
    int[] dc={0, -1, 1, 0};
    ArrayList<String> ans = new ArrayList<String>();
    boolean isValid(int row, int col, int n, int[][] mat){
        return row>=0 && col>=0 && row<n && col<n && mat[row][col]==1;
    }
    public ArrayList<String> findPath(int[][] mat) {
        // Your code here
        if(mat[0][0]!=1) return ans;
        util(0, 0, mat, new StringBuilder());
        return ans;
    }
    
    void util(int row, int col, int[][] mat, StringBuilder currentPath){
        int n = mat.length;
        if(row==n-1 && col==n-1){
            ans.add(currentPath.toString());
            return;
        }
        mat[row][col]=0;
        for(int i=0;i<4;i++){
            int nrow=row+dr[i];
            int ncol=col+dc[i];
            if(isValid(nrow, ncol, n, mat)){
                currentPath.append(dir.charAt(i));
                util(nrow, ncol, mat, currentPath);
                currentPath.deleteCharAt(currentPath.length()-1);
            }
        }
        mat[row][col]=1;
    }
}
