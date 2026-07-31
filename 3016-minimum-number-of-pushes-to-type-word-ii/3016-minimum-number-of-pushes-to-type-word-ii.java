class Solution {
    public int minimumPushes(String word) {
        int freq[]=new int[26];
        for(char c:word.toCharArray()){
            freq[c-'a']++;
        }
        Arrays.sort(freq);
        int p=1;
        int c=0;
        int ans=0;
        for(int i=25;i>=0;i--){
            if(freq[i]==0)break;
            ans+=freq[i]*p;
            c++;
            if(c==8){
                c=0;
                p++;
            }
        }
        return ans;
    }
}