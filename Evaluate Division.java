import java.util.*;

class Solution {

    Map<String, Integer> map = new HashMap<>();
    int nodes = 0;
    double[] res;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        res = new double[queries.size()];

       for (int i = 0; i < equations.size(); i++) {
            if (!map.containsKey(equations.get(i).get(0))) {
                map.put(equations.get(i).get(0), nodes);
                nodes++;
            }
            if (!map.containsKey(equations.get(i).get(1))) {
                map.put(equations.get(i).get(1), nodes);
                nodes++;
            }
        }

        for (int i = 0; i < queries.size(); i++) res[i] = -1;

        double[][] graph = new double[nodes][nodes];
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            if (map.containsKey(a) && map.containsKey(b)) {
                graph[map.get(a)][map.get(b)] = values[i];
                graph[map.get(b)][map.get(a)] = 1 / values[i];
            }
        }

        for (int i = 0; i < queries.size(); i++) {
            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);
            if (map.containsKey(a) && map.containsKey(b)) {
                if (a.equals(b)) res[i] = 1;
                else dfs(graph, i, map.get(a), map.get(b), 0.0, new boolean[nodes]);
            } else {
                res[i] = -1;
            }
        }
        return res;
    }

    private void dfs(double[][] graph, int q, int start, int end, double curr, boolean[] visited) {
        for (int j = 0; j < nodes; j++) {
            if (graph[start][j] != 0.0 && !visited[j]) {
                double val = 0.0;
                if (curr == 0.0) val = graph[start][j];
                else val = curr * graph[start][j];
                if (j == end) {
                    res[q] = val;
                    return;
                } else {
                    visited[start] = true;
                    dfs(graph, q, j, end, val, visited);
                }
            }
        }
    }
}