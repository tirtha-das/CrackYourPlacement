import java.util.*;

class Solution {
    
    ArrayList<Integer> traversal = new ArrayList<>();
    boolean[] visited;

    public void dfs(ArrayList<ArrayList<Integer>> adj, int node, int index) {
        if (node == adj.size() || index == adj.get(node).size())
            return;

        int next = adj.get(node).get(index);
        if (!visited[next]) {
            traversal.add(next);
            visited[next] = true;
            dfs(adj, next, 0);
        }

        dfs(adj, node, index + 1);
    }

    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        visited = new boolean[adj.size()];

        for (int elem = 0; elem < adj.size(); elem++) {
            if (visited[elem])
                continue;

            traversal.add(elem);
            visited[elem] = true;
            dfs(adj, elem, 0);
        }

        return traversal;
    }
}