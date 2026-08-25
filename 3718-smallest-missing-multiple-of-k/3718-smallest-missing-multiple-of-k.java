class Solution {
    public int missingMultiple(int[] nums, int k) {
        boolean[] present = new boolean[101];
        for(int x:nums){
            present[x]=true;
        }
        int mul=k;
        while(mul<=100){
            if(!present[mul]){
                return mul;
            }
            mul+=k;
        }
        return mul;
    }
}