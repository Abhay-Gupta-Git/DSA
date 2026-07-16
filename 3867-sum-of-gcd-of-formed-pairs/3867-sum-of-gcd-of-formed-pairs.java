class Solution {
    public long gcdSum(int[] nums) {
        int n=nums.length;
        int arr[]=new int [n];
        int max=0;
        for(int i=0;i<n;i++){
            max=Math.max(nums[i],max);
            arr[i]=gcd(nums[i],max);
        }
        Arrays.sort(arr);
        int left=0;
        int right=n-1;
        long sum=0;
        while(left<right){
            sum+=gcd(arr[left],arr[right]);
            left++;
            right--;
        }
        return sum;  
    }
    public static int gcd(int first,int sec){
        while(sec!=0){
            int third=sec;
            sec=first%sec;
            first=third;
        }
        return first;
    }
}