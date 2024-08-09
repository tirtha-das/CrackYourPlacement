class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSurplus = 0;
        int gasSofar = 0;
        int startIndex = 0;
        for (int i = 0; i < gas.length; i++) {
            gasSofar += gas[i] - cost[i];
            gasSurplus += gas[i] - cost[i];
            if (gasSofar < 0) {
                gasSofar = 0;
                startIndex = i + 1;
            }
        }
        return gasSurplus < 0 ? -1 : startIndex;
    }
}