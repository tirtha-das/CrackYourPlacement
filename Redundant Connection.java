class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length + 1;
        
        int[] parent = new int[n + 1];
        for(int i = 0; i <= n; i++) {
            parent[i] = i;
        }
        int[] rank = new int[n + 1];

        for(int j = 0; j < n-1; j++) {
            int uPar = findParent(edges[j][0], parent);
            int vPar = findParent(edges[j][1], parent);

            if(uPar == vPar) return new int[]{edges[j][0], edges[j][1]};
            
            if(rank[uPar] < rank[vPar]) {
                parent[uPar] = vPar;
            } else if(rank[uPar] > rank[vPar]) {
                parent[vPar] = uPar;
            } else {
                parent[vPar] = uPar;
                rank[uPar]++;
            }
        }
        return new int[]{};
    }
    private int findParent(int i, int[] parent) {
        if(parent[i] != i) {
            parent[i] = findParent(parent[i], parent);
        }
        return parent[i];
    }
}