
class Solution {
    public int maxSum(List<Integer> nums, int k) {
        long mod = 1000000007;
        int[] count = new int[31];
        for (int num : nums) {
            for (int j = 0; j < 31; j++) {
                if ((num & (1 << j)) != 0) {
                    count[j]++;
                }
            }
        }
        long ans = 0;
        for (int i = 0; i < k; i++) {
            long num = 0;
            for (int j = 0; j < 31; j++) {
                if (count[j] > 0) {
                    num += (1L << j);
                    count[j]--;
                }
            }
            ans = (ans + num * num) % mod;
        }
        return (int) ans;
    }
}
