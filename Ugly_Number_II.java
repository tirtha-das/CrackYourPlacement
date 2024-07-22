class Solution {
    static int count(int base){
        int val = Integer.MAX_VALUE;
        int cnt = 0;
        while(val>0){
            cnt++;
            val/=base;
        }

      // System.out.println(cnt);
       return cnt;
    }

    public int nthUglyNumber(int n) {
        int cnt2 = count(2);
        int cnt3 = count(3);
        int cnt5 = count(5);

       List<Long> arr=new ArrayList<>();

       for(int i=0;i<=cnt5;i++){
        for(int j=0;j<=cnt3;j++){
            for(int k=0;k<=cnt2;k++){
                long ans = (long)Math.pow(2,k)*(long)Math.pow(3,j)*(long)Math.pow(5,i);

                if(ans>Integer.MAX_VALUE){
                    break;
                }else{
                    arr.add(ans);
                }
            }

        }
       }

       Collections.sort(arr);

    long ans = arr.get(n-1);

        return (int)ans;
    }
}