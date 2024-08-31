import java.util.*;

class Solution {
    public String removeDuplicates(String s, int k) {
        StringBuilder result = new StringBuilder();
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);

            if (!stack.isEmpty() && stack.peek()[0] == ch) {
                stack.peek()[1]++;
            } else {
                stack.push(new int[]{ch, 1});
            }

            if (stack.peek()[1] == k) {
                stack.pop();
            }
        }

        while (!stack.isEmpty()) {
            int[] top = stack.pop();
            while (top[1]-- > 0) {
                result.append((char) top[0]);
            }
        }

        return result.reverse().toString();
    }
}