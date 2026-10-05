class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(0);
            } else {
                int x = stack.pop();
                int value;
                if (x == 0) {
                    value = 1;
                } else {
                    value = 2 * x;
                }
                int previous = stack.pop();
                stack.push(previous + value);
            }
        }
        return stack.pop();
    }
}