import java.util.*;

class Solution {
    public int characterReplacement(String s, int k) {
        int maxWindow = 0;
        int left = 0;
        int maxRepeat = 0;

        Map<Character, Integer> map = new HashMap<>();
        for(int right = 0; right < s.length(); right++) {
            char curr = s.charAt(right);
            map.put(curr, map.getOrDefault(curr, 0) + 1);            
            maxRepeat = Math.max(maxRepeat, map.get(curr));
            if(right - left - maxRepeat >= k) {
                char remove = s.charAt(left);
                map.put(remove, map.get(remove) -1);
                left ++;
            }
            maxWindow = Math.max(maxWindow, right - left + 1);

        }
        return maxWindow;
    }
}