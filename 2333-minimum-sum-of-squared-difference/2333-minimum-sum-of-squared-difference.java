class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long total = (long) k1 + k2;
        int max = 0;

        int[] diff = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            max = Math.max(max, diff[i]);
        }

        if (total >= 0) {
            long sum = 0;

            for (int i = 0; i < diff.length; i++) {
                sum += diff[i];
            }

            if (total >= sum) {
                return 0;
            }
        }

        int left = 0;
        int right = max;

        while (left < right) {
            int mid = left + (right - left) / 2;
            long need = 0;

            for (int i = 0; i < diff.length; i++) {
                if (diff[i] > mid) {
                    need += diff[i] - mid;
                }
            }

            if (need <= total) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        int level = left;
        long remaining = total;
        long answer = 0;

        for (int i = 0; i < diff.length; i++) {
            if (diff[i] > level) {
                remaining -= diff[i] - level;
                diff[i] = level;
            }
        }

        for (int i = 0; i < diff.length && remaining > 0; i++) {
            if (diff[i] == level && level > 0) {
                diff[i]--;
                remaining--;
            }
        }

        for (int i = 0; i < diff.length; i++) {
            answer += (long) diff[i] * diff[i];
        }

        return answer;
    }
}