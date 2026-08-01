class Solution {
    public int countValidPrefixes(String s) {
        int z=0;
        int o=0;
        int ans=0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='0'){
                z++;
            }else{
                o++;
            }
            if(Math.abs(z-o)<=1){
                ans++;
            }
        }
        return ans;
    }
}