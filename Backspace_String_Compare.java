class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;

        while (i >= 0 || j >= 0) {
            int sCount = 0;
            while (i >= 0 && (s.charAt(i) == '#' || sCount > 0)) {
                if (s.charAt(i) == '#') {
                    sCount++;
                } else {
                    sCount--;
                }
                i--;
            }
            
            int tCount = 0;
            while (j >= 0 && (t.charAt(j) == '#' || tCount > 0)) {
                if (t.charAt(j) == '#') {
                    tCount++;
                } else {
                    tCount--;
                }
                j--;
            }

            if (i < 0 || j < 0) {
                return i == j;
            }

            if (s.charAt(i) != t.charAt(j)) {
                return false;
            }

            i--;
            j--;
        }

        return true;
    }
}