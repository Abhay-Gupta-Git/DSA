class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans=new ArrayList<>();
        for (int start=1;start<=9;start++) {
            int x=start;
            int next=start+1;
            while(next<=9){
                x=x*10+next;
                if(x>=low && x<=high){
                    ans.add(x);
                }
                next++;
            }
        }
        Collections.sort(ans);
        return ans;
    }
}