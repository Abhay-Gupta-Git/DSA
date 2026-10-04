class Solution {
    public boolean checkValidString(String s) {
        int minOpen = 0;
        int maxOpen = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // '(' → must open
            if (ch == '(') {
                minOpen = minOpen + 1;
                maxOpen = maxOpen + 1;
            }

            // ')' → must close
            else if (ch == ')') {
                minOpen = minOpen - 1;
                maxOpen = maxOpen - 1;
            }

            // '*' → can be '(' or ')' or empty
            else {
                // Assume '*' as ')'
                minOpen = minOpen - 1;

                // Assume '*' as '('
                maxOpen = maxOpen + 1;
            }

            // If too many ')', invalid
            if (maxOpen < 0) {
                return false;
            }

            // minOpen cannot be negative (we can treat '*' as empty)
            if (minOpen < 0) {
                minOpen = 0;
            }
        }

        // If all opened brackets are matched
        if (minOpen == 0) {
            return true;
        } else {
            return false;
        }
    }
}
