class Solution {
    public boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        boolean checkPalindromeOnce = false;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                checkPalindromeOnce = true;
                break;
            } else {
                start++;
                end--;
            }
        }
        if (checkPalindromeOnce) {
            checkPalindromeOnce = false;
            int tempStart = start + 1;
            int tempEnd = end;
            while (tempStart < tempEnd) {
                if (s.charAt(tempStart) != s.charAt(tempEnd)) {
                    checkPalindromeOnce = true;
                    break;
                } else {
                    checkPalindromeOnce = false;
                    tempStart++;
                    tempEnd--;
                }
            }
            if(checkPalindromeOnce){
            tempStart = start;
            tempEnd = end - 1;
            while (tempStart < tempEnd) {
                if (s.charAt(tempStart) != s.charAt(tempEnd)) {
                    checkPalindromeOnce = true;
                    break;
                } else {
                    checkPalindromeOnce = false;
                    tempStart++;
                    tempEnd--;
                }
            }
            }
            if (checkPalindromeOnce)
                return false;
        }
        return true;
    }
}