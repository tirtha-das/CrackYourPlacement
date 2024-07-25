class Solution {
    public String addBinary(String a, String b) {
        int n = a.length(), m = b.length();
        if(n > m) return addBinary(b, a);
        char[] A = a.toCharArray();
        char[] B = b.toCharArray();
        char c = '0';
        int i, j;
        for(i = m - 1, j = n - 1; j > -1; i--, j--){
            if(B[i] == '0' && A[j] == '0'){
                if(c == '0')
                    continue;
                c = '0';
                B[i] = '1';
            }
            else if(B[i] == '1' && A[j] == '1'){
                if(c == '0')
                    B[i] = '0';
                c = '1';
            }
            else{
                if(c == '1'){
                    c = '1';
                    B[i] = '0';
                    continue;
                }
                B[i] = '1';
                c = '0';
            }
        }
        while(i > -1 && c != '0'){
            if(B[i] == '1')
                B[i] = '0';
            else{
                B[i] = '1';
                c = '0';
            }
            i--;
        }
        String sum = String.valueOf(B);
        if(c == '1')
            sum = "1" + sum;
        return sum;
    }
}