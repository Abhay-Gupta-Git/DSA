public class Solution {
    public int hammingWeight(int n) {
        // int count = 0;
        // while (n != 0) {
        //     n = n & (n - 1); // removes the lowest 1 bit
        //     count++;
        // }
        // return count;

        int c=0;
        int mask=1;
        for(int i=0;i<32;i++){
            if((n&mask)!=0){
                c++;
            }
            mask<<=1;
        }
        return c;
    }
}
