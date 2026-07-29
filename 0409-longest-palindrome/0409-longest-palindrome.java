class Solution {
    public int longestPalindrome(String s) {
        int[] arr=new int[128];
        for(char c:s.toCharArray()){
            arr[c]++;
        }
        int ans=0;
        boolean odd=false;
        for(int i:arr){
            if(i%2==0){
                ans+=i;
            }else{
                ans+=i-1;
                odd=true;
            }
        }
        if(odd){
            ans++;
        }
        return ans;
    }
}