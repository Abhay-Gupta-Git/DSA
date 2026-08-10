class Solution {
    public int lastStoneWeight(int[] stones) {
        int n=stones.length;
        for(int i=0; i<n-1; i++){
            Arrays.sort(stones);
            int a=stones[n-1];
            int b=stones[n-2];
            if (a==b) {
                stones[n-1]=0;
                stones[n-2]=0;
            }else{
                stones[n-1]=a-b;
                stones[n-2]=0;
            }
        }
        Arrays.sort(stones);
        return stones[n-1];
    }
}