class Solution {
    public int maxProduct(int[] nums) {
        int max=0;
        int key=0;
        for(int n:nums){
            if(n>max){
                key=max;
                max=n;
            }else if(n>key){
                key=n;
            }
        }
        return (max-1)*(key-1);
    }
}