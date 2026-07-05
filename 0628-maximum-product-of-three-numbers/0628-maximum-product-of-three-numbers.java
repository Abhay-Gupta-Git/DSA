class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int m1=nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3];
        int m2=nums[nums.length-1]*nums[0]*nums[1];
        int max= Math.max(m1,m2);
        return max;
    }
}