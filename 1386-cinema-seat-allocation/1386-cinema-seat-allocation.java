import java.util.*;
class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer, int[]> map = new HashMap<>();
        for (int i=0; i<reservedSeats.length; i++){
            int row=reservedSeats[i][0];
            int seat=reservedSeats[i][1]-1;
            if(!map.containsKey(row)){
                map.put(row,new int[10]);
            }
            map.get(row)[seat]=1;
        }
        int ans=(n-map.size())*2;
        for(int row:map.keySet()){
            int[] arr=map.get(row);
            boolean left=true;
            boolean middle=true;
            boolean right=true;
            for(int j=1; j<=4; j++){
                if(arr[j]==1){
                    left=false;
                }
            }
            for(int j=3; j<=6; j++){
                if(arr[j]==1){
                    middle=false;
                }
            }
            for(int j=5; j<=8; j++){
                if(arr[j]==1){
                    right=false;
                }
            }
            if(left && right){
                ans+=2;
            } 
            else if(left || middle || right){
                ans+=1;
            }
        }

        return ans;
    }
}