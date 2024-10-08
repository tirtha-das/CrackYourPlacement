class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (informTime[i] == 0) continue;  max = Math.max(max, dfs(i, manager, informTime));
        }
        return max;
    }

    private int dfs(int emp, int[] manager, int[] informTime) {
        if (manager[emp] != -1) {
            informTime[emp] += dfs(manager[emp], manager, informTime);
            manager[emp] = -1;
        }
        return informTime[emp];
    }
}