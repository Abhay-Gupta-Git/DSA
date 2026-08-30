class Solution {
    public int minimumDeletions(int[] nums) {

        int n = nums.length;

        int minIndex = 0;
        int maxIndex = 0;

        // Minimum aur maximum ka index find karo
        for (int i = 1; i < n; i++) {

            if (nums[i] < nums[minIndex]) {
                minIndex = i;
            }

            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        // Dono left se
        int left = Math.max(minIndex, maxIndex) + 1;

        // Dono right se
        int right = n - Math.min(minIndex, maxIndex);

        // Ek left se, ek right se
        int both = Math.min(minIndex, maxIndex) + 1
                 + n - Math.max(minIndex, maxIndex);

        return Math.min(left, Math.min(right, both));
    }
}