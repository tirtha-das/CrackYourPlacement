import java.util.PriorityQueue;

class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> (b[1] - b[0]) - (a[1] - a[0]));

        int max = Integer.MIN_VALUE;

        for (int[] point : points) {
            while (!maxHeap.isEmpty() && point[0] - maxHeap.peek()[0] > k) {
                maxHeap.poll();
            }

            if (!maxHeap.isEmpty()) {
                int[] top = maxHeap.peek();
                int result = top[1] - top[0] + point[1] + point[0];
                max = Math.max(max, result);
            }

            maxHeap.offer(point);
        }

        return max;
    }
}