class Solution {
    public int smallestNumber(int n, int t) {
        for(int i=n; ; i++){
            int mul=1;
            for (int x=i; x>0; x/=10){
                mul*=(x%10);
            }
            if(mul%t==0){
                return i;
            }
        }
    }
}