class Solution {
    public int fillCups(int[] amount) {
        int sum=amount[0]+amount[1]+amount[2];
        int max=amount[0];
        if(amount[1]>max){
            max=amount[1];
        }
        if(amount[2]>max){
            max=amount[2];
        }
        return Math.max(max,(sum+1)/2);
    }
}