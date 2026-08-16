class Solution {
    public boolean stoneGameIX(int[] stones) {
        int c0 = 0;
        int c1 = 0;
        int c2 = 0;
        for (int i = 0; i < stones.length; i++) {
            int mod = stones[i] % 3;
            if (mod == 0) {
                c0++;
            } else if (mod == 1) {
                c1++;
            } else {
                c2++;
            }
        }
        if (c0 % 2 == 0) {
            return c1 >= 1 && c2 >= 1;
        }
        return Math.abs(c1 - c2) > 2;
    }
}
