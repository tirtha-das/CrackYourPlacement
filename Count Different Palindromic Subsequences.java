import java.util.*;

class Solution {
    public int countPalindromicSubsequences(String s) {
        int mod = (int)1e9+7;
        int dp[][] = new int[s.length()][s.length()];
        int []prev = new int[s.length()];
        int []next  = new int[s.length()];
        HashMap<Character ,Integer>map = new HashMap <>();

        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)==false){
                prev[i] =-1;
            }else{
                prev[i] = map.get(ch);
            }
            map.put(ch,i);
        }

        map.clear();
        for(int i = s.length()-1;i>=0;i--){
        char ch = s.charAt(i);
        if(map.containsKey(ch)==false){
            next[i] =-1;
        }else{
            next[i] = map.get(ch);
        }
        map.put(ch,i);
    }

        for(int g =0 ; g<s.length();g++){
            for(int i =0 ,j =g ; j<s.length();i++,j++){
                if(g==0){
                    dp[i][j] = 1;
                }else if(g==1){
                    dp[i][j] = 2;
                }else{
                    char sc = s.charAt(i);
                    char ec = s.charAt(j);
                    if(sc!=ec){
                        dp[i][j]  = (dp[i+1][j]+dp[i][j-1]-dp[i+1][j-1]);
                    }else{
                        int n = next[i];
                        int p = prev[j];
                        if(n>p){
                            dp[i][j] = (2*dp[i+1][j-1]+2);
                        }else if(n==p){
                            dp[i][j] = (2*dp[i+1][j-1]+1);
                        }else{
                            dp[i][j] = (2*dp[i+1][j-1] - dp[n+1][p-1])%mod;
                        }
                    }
                }
                  dp[i][j] = dp[i][j] < 0 ? dp[i][j] + 1000000007 : dp[i][j] % 1000000007;
            }
        }
        return dp[0][s.length()-1]%mod;
    }
}