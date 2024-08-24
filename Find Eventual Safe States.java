import java.util.*;


class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            for (int node : graph[i]) {
                adj[node].add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            int i = q.poll();
            ans.add(i);

            for (int node : adj[i]) {
                indegree[node]--;
                if (indegree[node] == 0) {
                    q.add(node);
                }
            }
        }

        Collections.sort(ans);
        return ans;
    }
}