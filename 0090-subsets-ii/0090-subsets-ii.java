class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>list=new ArrayList<>();
        print(nums,0,list,ans);
        return ans;
    }
        public static void print(int[]arr,int i,List<Integer>list,List<List<Integer>>ans){
        if(i==arr.length){
            if(ans.contains(list)){
                return;
            }
            else{
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        list.add(arr[i]);
        print(arr,i+1,list,ans);
        list.remove(list.size()-1);
        print(arr,i+1,list,ans);
    }
}