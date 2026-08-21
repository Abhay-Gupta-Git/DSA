class Solution {
    public int numberOfAlternatingGroups(int[] colors) {
        int n = colors.length;
        int count=0;
        for (int i=0; i<n; i++) {
            int prev=colors[(i-1+n)%n];
            int next=colors[(i+1)%n];
            if (prev != colors[i] && colors[i] != next) {
                count++;
            }
        }
        return count;
    }
}