class Solution {
    public int maximumCandies(int[] candies, long k) {
    int max=Integer.MIN_VALUE;
    for(int i=0;i<candies.length;i++){
        max=Math.max(max,candies[i]);
    }
    long result=0;
    int left=1;
    int right=max;
    while(left<=right){
        int mid=left+(right-left)/2;
        long valid=count(candies,mid);
        if(valid>=k){
            result=mid;
            left=mid+1;
        }
        else{
            right=mid-1;
        }
        }
        return (int)result;
    }
    public static long count(int []arr,int m){
        long ans=0;
        for(int i=0;i<arr.length;i++){
            ans+=arr[i]/m;
        }
        return ans;
    }
}