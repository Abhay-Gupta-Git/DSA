class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int round=minutesToTest/minutesToDie;
        int state=round+1;
        int pig=0;
        int com=1;
        while (com<buckets){
            com=com*state;
            pig++;
        }

        return pig;
    }
}