class Solution {
    public String convertDateToBinary(String date) {
        String[] arr=date.split("-");
        int year=Integer.parseInt(arr[0]);
        int month=Integer.parseInt(arr[1]);
        int day=Integer.parseInt(arr[2]);

        String a=Integer.toBinaryString(year);
        String b=Integer.toBinaryString(month);
        String c=Integer.toBinaryString(day);
        return a + "-" + b + "-" + c;
    }
}