class Solution {
    public int maxDepth(String s) {
        int count = 0; 
        int ans = 0; 
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                count = count +1;
                if (count > ans) {
                    ans = count;
                }
            }
            else if (ch == ')') {
                count = count - 1;
            }
            else {
            }
        }

        return ans;
    }
}
