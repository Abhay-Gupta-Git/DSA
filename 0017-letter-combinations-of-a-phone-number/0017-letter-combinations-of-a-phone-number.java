class Solution {

    static String[] key = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    List<String> list = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return list;
        }
        keypaid(digits, "");
        return list;
    }
    public void keypaid(String ques, String ans) {   // 239
        if (ques.length() == 0) {
            list.add(ans);        //  print ki jagah add
            return;
        }

        char ch = ques.charAt(0);    //2
        String get = key[ch - '0'];   // 2 → "abc"

        for (int i = 0; i < get.length(); i++) {
            keypaid(ques.substring(1), ans + get.charAt(i));
        }
    }
}
