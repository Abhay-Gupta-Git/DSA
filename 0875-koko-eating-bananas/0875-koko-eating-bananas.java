class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left=1;
        int right=0;
        for(int i=0; i<piles.length; i++){
            int p=piles[i];
            if(p>right){
                right=p;
            }
        }
        while(left<right){
            int mid=left+(right-left)/2;  
            long hours=0;
            for(int i=0; i<piles.length; i++){
                int p=piles[i];
                int time=(p+mid-1)/mid;
                hours+=time;
            }
            if(hours<=h){
                right=mid;
            } 
            else{
                left=mid+1;
            }
        }
        return left;
    }
}
