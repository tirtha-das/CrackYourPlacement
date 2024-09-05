import java.util.*;

class Solution {
    public int minimumCostOfBreaking(int[] X, int[] Y, int M, int N) {
        int v = 1, h = 1;
        int cost = 0;
        
        Arrays.sort(X);
        Arrays.sort(Y);
        
        int m = X.length - 1;
        int n = Y.length - 1;
        
        while (m >= 0 && n >= 0) {
            if (X[m] >= Y[n]) {
                cost += v * X[m];
                h++;
                m--;
            } else {
                cost += h * Y[n];
                n--;
                v++;
            }
        }
        
        while (m >= 0) {
            cost += v * X[m];
            m--;
        }
        
        while (n >= 0) {
            cost += h * Y[n];
            n--;
        }
        
        return cost;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            
            int[] X = new int[m - 1];
            int[] Y = new int[n - 1];
            
            for (int i = 0; i < m - 1; i++) {
                X[i] = sc.nextInt();
            }
            for (int i = 0; i < n - 1; i++) {
                Y[i] = sc.nextInt();
            }
            
            Solution ob = new Solution();
            int ans = ob.minimumCostOfBreaking(X, Y, m, n);
            System.out.println(ans);
        }
        sc.close();
    }
}
