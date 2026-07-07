class Solution {
    public long sumAndMultiply(int n) {
        long sum=0;
        long place=1;
        while(n!=0){
            int rem=n%10;
            if(rem!=0){
                sum=rem*place+sum;
                place*=10;
            }
            n/=10;
        }
        int sum1=0;
        long temp=sum;
        while(temp!=0){
            long rem=temp%10;
            sum1+=rem;
            temp/=10;
        }
        return sum*sum1;
    }
}