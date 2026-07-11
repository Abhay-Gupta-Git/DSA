class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] copy=nums.clone();
        Arrays.sort(copy);
        int left=0;
        int right=nums.length-1;
        while (left<nums.length && nums[left]==copy[left]) {
            left++;
        }
        while (right>=0 && nums[right]==copy[right]) {
            right--;
        }
        if(left>=right) {
            return 0;
        }
        return right-left+1;
    }
}