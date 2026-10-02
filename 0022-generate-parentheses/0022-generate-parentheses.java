class Solution {
    public List<String> generateParenthesis(int n) {
         List<String>ll=new ArrayList<>();
        paranthesis(n,0,0,"",ll);
        return ll;

    }
     public static void paranthesis(int n,int open,int closed,String ans,  List<String>ll){
        if(open==n && closed==n){
       //   System.out.println(ans);
          ll.add(ans);
          return;
        }
        if(open>n || closed>open){
            return;
        }
        paranthesis(n, open+1, closed, ans+"(",ll);
        paranthesis(n, open, closed+1, ans+")",ll);
    }
}