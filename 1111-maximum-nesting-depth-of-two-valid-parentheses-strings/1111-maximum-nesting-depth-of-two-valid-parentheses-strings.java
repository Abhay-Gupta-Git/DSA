class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n=seq.length();
        int[] ans= new int[n];
        int c=0;
        for(int i=0;i<n;i++){
            if(seq.charAt(i)=='('){
                c++;
                ans[i]=c%2;
            }else{
                ans[i]=c%2;
                c--;
            }
        }
        return ans;
    } 
}