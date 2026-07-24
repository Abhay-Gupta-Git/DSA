class Solution {
    public int generateKey(int num1, int num2, int num3) {
        int ans=0;
        int place = 1;

        for(int i=0; i<4; i++){
            int a=num1%10;
            int b=num2%10;
            int c=num3%10;
            int min=Math.min(a,Math.min(b,c));
            ans=ans+min*place;
            place = place * 10;
            num1/=10;
            num2/=10;
            num3/=10;
        }
        return ans;
    }
}