class Solution {
    public int search(int[] arr, int y) {
        int low=0;
        int high=arr.length-1;
        int idx=-1;
        while (low <= high) {
            int mid=(low+high)/2;
            if(arr[mid]==y){
                idx=mid;
                break;
            }else if(arr[mid]<y) {
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        if (idx==-1){
            return -1;
        } else {
            return idx;
        }
    }
}