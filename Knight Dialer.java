class Solution {
    long array[][],matrix[][],mod=1000000007;
  void multiply(long ref1[][],long ref2[][]){
        long[][] ref=new long[ref1.length][ref2[0].length];
        for(int i=0;i<ref.length;i++)
            for(int j=0;j<ref2[0].length;j++)
                for(int k=0;k<ref2.length;k++)
                    ref[i][j]=(int)((ref[i][j]+ref1[i][k]*ref2[k][j]%mod)%mod);
        if(ref1!=ref2)array=ref;
        else matrix=ref;
    }
    public int knightDialer(int n) {
        matrix=new long[][]{{0,0,0,2}, {0,0,1,1}, {0,2,0,0}, {1,2,0,0}};
        array=new long[][]{{1,0,0,0},{0,1,0,0},{0,0,1,0},{0,0,0,1}};
        if(n==1)return 10;n-=2;
        while(n!=0){
            if(n%2==1){multiply(array,matrix);n--;}
            else {multiply(matrix,matrix);n/=2;}
        }
        multiply(array,new long[][]{{2},{2},{2},{3}});
        return (int)((((array[0][0]+array[1][0]*4%mod)%mod+array[2][0]*2%mod)%mod+array[3][0]*2%mod)%mod);
    }
}