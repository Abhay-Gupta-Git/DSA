class Solution {
    public long countCommas(long n) {
        long ans=0;
        long s=1000;
        int com=1;
        while(s<=n){
            long end=s*1000-1;
            long count=Math.min(n,end)-s+1;
            ans+=count*com;
                s*=1000;
            com++;
        }
        return ans;
    }
}