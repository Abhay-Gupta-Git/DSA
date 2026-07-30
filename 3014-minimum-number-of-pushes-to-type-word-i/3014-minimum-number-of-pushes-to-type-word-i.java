class Solution {
    public int minimumPushes(String word) {
        int len = word.length();
        if(len<=8) return len;
        if(len>8 && len<=16) return 8+(len-8)*2;
        if(len>16 && len<=24) return 8+2*8+(len-16)*3;
        if(len>24) return 8+8*2+8*3+(len-24)*4;
        return 0;
    }
}