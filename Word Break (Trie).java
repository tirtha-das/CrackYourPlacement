import java.util.*;

class Solution
{
    public static int wordBreak(String A, ArrayList<String> B )
    {
        //code here
         if (B.contains(A))
            return 1;
        int n = A.length();
        for (int i = 1; i <= n; i++) {
            if (B.contains(A.substring(0, i)) && wordBreak(A.substring(i), B) == 1)
                return 1;
        }
        return 0;
        
        
    }
}