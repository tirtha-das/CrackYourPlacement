class NumArray {
    private int[] st;
    private int n;
    private int[] nums;
    public NumArray(int[] nums) {
        this.n = nums.length;
        this.st = new int[4*this.n];
        this.nums = nums;
        construct(0, this.n-1, 0);
    }
    
    private int construct(int s, int e, int idx) {
        if (s > e) return 0;
        if (s == e) {
            st[idx] = nums[s];
            return st[idx];
        }
        int mid = s + (e-s)/2;
        st[idx] = construct(s, mid, 2*idx+1) + construct(mid+1, e, 2*idx+2);
        return st[idx];
    }
    
    public void update(int index, int val) {
        if (index < 0 || index >= this.n) return;
        int diff = val - this.nums[index];
        this.nums[index] = val;
        updateUtil(0, this.n-1, 0, index, diff);
    }
    
    private void updateUtil(int s, int e, int idx, int i, int diff) {
        if (i < s || i > e) return;
        st[idx] += diff;
        if (s != e) {
            int mid = s + (e-s)/2;
            updateUtil(s, mid, 2*idx+1, i, diff);
            updateUtil(mid+1, e, 2*idx+2, i, diff);
        }
    }
    
    public int sumRange(int left, int right) {
        if (left > right || left < 0 || right >= this.n) return 0;
        return sumRangeUtil(0, this.n-1, 0, left, right);
    }
    
    private int sumRangeUtil(int s, int e, int idx, int qs, int qe) {
        if (qs > e || qe < s) {
            return 0;
        }
        if (s >= qs && e <= qe) {
            return st[idx];
        }
        int mid = s + (e-s)/2;
        int res = sumRangeUtil(s, mid, 2*idx+1, qs, qe) + sumRangeUtil(mid+1, e, 2*idx+2, qs,  qe);
        return res;
    }
}