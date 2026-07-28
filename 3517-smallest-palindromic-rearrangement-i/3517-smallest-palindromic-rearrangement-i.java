class Solution {
    public String smallestPalindrome(String s) {
        int n=s.length();
        int[] freq=new int[26];
        for(int i=0;i<n;i++){
            freq[s.charAt(i)-'a']++;
        }
        char[] ans=new char[n];
        int left=0;
        int right=n-1;
        for(int i=0;i<26;i++){
            while(freq[i]>=2){
                ans[left]=(char)(i+'a');
                ans[right]=(char)(i+'a');
                left++;
                right--;
                freq[i]-=2;
            }
            if(freq[i]==1) {
                ans[n/2]=(char)(i+'a');
            }
        }

        return new String(ans);
    }
}