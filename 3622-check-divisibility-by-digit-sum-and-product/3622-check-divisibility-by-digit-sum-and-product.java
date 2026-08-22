class Solution {
    public boolean checkDivisibility(int n) {
        int temp=n;
        int sum=0;
        int product=1;
        //if(n<10) return false;
        while(n!=0){
            sum+=n%10;
            product*=n%10;
            n/=10;
        }
        return temp%(sum+product)==0;
    }
}