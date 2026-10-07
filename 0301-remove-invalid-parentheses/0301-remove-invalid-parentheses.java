import java.util.*;
class Solution {
    Set<String> ans = new HashSet<>();
    public List<String> removeInvalidParentheses(String s) {
        int open = 0;
        int close = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                open++;
            }
            else if (s.charAt(i) == ')') {
                if (open > 0) {
                    open--;
                }
                else {
                    close++;
                }
            }
        }
        solve(s, 0, 0, 0, open, close, "");
        return new ArrayList<>(ans);
    }
    public void solve(String s, int index, int open,
                      int close, int removeOpen,
                      int removeClose, String current) {
        if (index == s.length()) {
            if (removeOpen == 0 &&
                removeClose == 0 &&
                open == close) {
                ans.add(current);
            }
            return;
        }
        char ch = s.charAt(index);
        if (ch == '(') {
            // Remove '('
            if (removeOpen > 0) {
                solve(s, index + 1, open, close,
                      removeOpen - 1, removeClose, current);
            }
            // Keep '('
            solve(s, index + 1, open + 1, close,
                  removeOpen, removeClose, current + ch);
        }
        else if (ch == ')') {
            // Remove ')'
            if (removeClose > 0) {
                solve(s, index + 1, open, close,
                      removeOpen, removeClose - 1, current);
            }
            // Keep ')' only if it has a matching '('
            if (close < open) {
                solve(s, index + 1, open, close + 1,
                      removeOpen, removeClose, current + ch);
            }
        }
        else {
            // Letter
            solve(s, index + 1, open, close,
                  removeOpen, removeClose, current + ch);
        }
    }
}