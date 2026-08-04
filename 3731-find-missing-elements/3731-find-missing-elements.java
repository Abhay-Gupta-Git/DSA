class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        Arrays.sort(nums);
        int min=nums[0];
        int max=nums[nums.length-1];
        for(int i=min+1; i<max; i++){
            boolean flag=false;
            for(int j=0; j<nums.length; j++){
                if(nums[j]==i){
                    flag=true;
                    break;
                }
            }
            if(!flag){
                ans.add(i);
            }
        }
        return ans;
    }
}