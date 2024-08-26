import java.util.*;

class Disjoint{
    int[] rank;
    int[] parent;
    public Disjoint(int n){
        rank = new int[n+1];
        parent = new int[n+1];
        Arrays.fill(rank , 1);
        for(int i = 0 ; i<=n ; i++){
            parent[i] = i;
        }
    }
    public int findUPar(int node){
        if (node == parent[node]) {
            return node;
        }
        int ulp = findUPar(parent[node]);
        parent[node] =  ulp;
        return parent[node];
    }
    public void unionByRank(int u , int v){
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (rank[ulp_u] < rank[ulp_v]) {
            parent[ulp_u] =  ulp_v;
        } else if (rank[ulp_v] < rank[ulp_u]) {
            parent[ulp_v] = ulp_u;
        } else {
            parent[ulp_v] = ulp_u;
            int rankU = rank[ulp_u];
            rank[ulp_u] =  rankU + 1;
        }
    }
}
class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        Disjoint d = new Disjoint(n);
        Map<Integer, List<Integer>> row = new HashMap<>();
        Map<Integer, List<Integer>> col = new HashMap<>();
        for(int i = 0; i<n; i++){
            row.computeIfAbsent(stones[i][0], k -> new ArrayList<>()).add(i);
            col.computeIfAbsent(stones[i][1], k -> new ArrayList<>()).add(i);
        }
        for(List<Integer> stone : col.values()){
            for (int i = 0; i < stone.size() - 1; i++) {
                d.unionByRank(stone.get(i), stone.get(i + 1));
            }
        }
        for(List<Integer> stone : row.values()){
            for (int i = 0; i < stone.size() - 1; i++) {
                d.unionByRank(stone.get(i), stone.get(i + 1));
            }
        }
        int cnt = 0;
        for(int i = 0; i<n; i++){
            if(d.findUPar(i) == i){
                cnt++;
            }
        }
        return n - cnt;
    }
}