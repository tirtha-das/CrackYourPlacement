import java.util.*;

class Pair {
    int node;
    int distance;

    public Pair(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}

class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        ArrayList<ArrayList<Pair>> list = new ArrayList<>();
        
        for (int i = 0; i < V; i++) {
            list.add(new ArrayList<>());
        }
        
        for (int i = 0; i < adj.size(); i++) {
            for (int[] ed : adj.get(i)) {
                list.get(i).add(new Pair(ed[0], ed[1]));
                // Since it's an undirected graph, you only add the reverse edge once
                list.get(ed[0]).add(new Pair(i, ed[1]));
            }
        }
        
        int ans = 0;
        boolean[] isVisited = new boolean[V];
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        pq.offer(new Pair(0, 0));
        
        while (!pq.isEmpty()) {
            Pair pair = pq.remove();
            int node = pair.node;
            int distance = pair.distance;
            
            if (isVisited[node]) {
                continue;
            }
            
            isVisited[node] = true;
            ans += distance;
            
            for (Pair grid : list.get(node)) {
                int newNode = grid.node;
                int newDistance = grid.distance;
                if (!isVisited[newNode]) {
                    pq.offer(new Pair(newNode, newDistance));
                }
            }
        }
        
        return ans;
    }
}