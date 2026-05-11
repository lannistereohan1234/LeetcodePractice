import java.util.*;

class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        // Edge case: if k equals the length of num, all digits are removed
        if (k == n) return "0";

        Deque<Character> stack = new ArrayDeque<>();
        char[] digits = num.toCharArray();

        // 1. Build monotonic increasing stack
        for (char c : digits) {
            while (!stack.isEmpty() && k > 0 && stack.peek() > c) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }

        // 2. If k > 0, remove remaining digits from the top (right side)
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }

        // 3. Build string from bottom of stack (left-to-right)
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            // pollLast() retrieves from the bottom of the stack (the start of the number)
            char curr = stack.pollLast();
            
            // Skip leading zeros
            if (sb.length() == 0 && curr == '0') continue;
            sb.append(curr);
        }

        // 4. Final check for empty string
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
