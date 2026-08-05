class Solution {
    public boolean search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) return true;
            if (nums[m] == nums[r]) { // duplicates, shrink
                r--;
            } else if (nums[m] < nums[r]) { // right half sorted
                if (target > nums[m] && target <= nums[r]) l = m + 1;
                else r = m - 1;
            } else { // left half sorted
                if (target >= nums[l] && target < nums[m]) r = m - 1;
                else l = m + 1;
            }
        }
        return false;
    }
}