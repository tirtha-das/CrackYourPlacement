class Solution
{
    public long findMinDiff (ArrayList<Integer> a, int n, int m)
    {
        // your code here
        Collections.sort(a);
        long mini=Long.MAX_VALUE;
        for(int i=0;i<n;i++){
            int start=i;
            if(i==n-m+1)
            break;
            int end=start+m-1;
            long temp=a.get(end)-a.get(start);
            if(temp<mini)
            mini=temp;
        }
        return mini;
    }
}