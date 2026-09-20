class Solution {
    public int reverseDegree(String s) {
        int sum=0;
        int idx=1;
        for(char c:s.toCharArray()){
            sum+=('z'-c+1)*idx;
            idx++;
        }
        return sum;
    }
}