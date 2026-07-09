class Solution {
    public int minCost(String colors, int[] neededTime) {
        int ans=0;
        int max=neededTime[0];
        for (int i=1; i<colors.length(); i++) {
            if(colors.charAt(i)==colors.charAt(i-1)){
                ans+=Math.min(max,neededTime[i]);
                max=Math.max(max,neededTime[i]);
            } 
            else{
                max=neededTime[i];
            }
        }
        return ans;
    }
}