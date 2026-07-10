class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int l=1;
        int w=0;
        for(int i=0;i<s.length();i++){
            int current=widths[s.charAt(i)-'a'];
            if (w+current<=100) {
                w+=current;
            } 
            else{
                l++;
                w=current;
            }
        }
        return new int[]{l,w};
    }
}