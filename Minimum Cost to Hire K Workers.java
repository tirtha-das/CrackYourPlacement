import java.util.*;

class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        double minCost = Double.MAX_VALUE;
        
        List<double[]> workers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            workers.add(new double[]{(double) wage[i] / quality[i], (double) quality[i]});
        }
        
        Collections.sort(workers, (a, b) -> Double.compare(a[0], b[0]));
        
        PriorityQueue<Double> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        double qualitySum = 0;
        
        for (double[] worker : workers) {
            qualitySum += worker[1];
            maxHeap.offer(worker[1]);
            
            if (maxHeap.size() > k) {
                qualitySum -= maxHeap.poll();
            }
            
            if (maxHeap.size() == k) {
                minCost = Math.min(minCost, qualitySum * worker[0]);
            }
        }
        return minCost;
    }
}