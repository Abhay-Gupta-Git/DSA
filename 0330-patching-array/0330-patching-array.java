class Solution {
    public int minPatches(int[] nums, int n) {
        long miss = 1;
        int i = 0;
        int answer = 0;

        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                miss = miss + nums[i];
                i++;
            } else {
                miss = miss + miss;
                answer++;
            }
        }

        return answer;
    }
}