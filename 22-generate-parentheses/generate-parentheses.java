class Solution {
    public void generate(List<String> result, int n, int open, int close, String unProcessed){

        if( unProcessed.length() == (2*n)){
            result.add(unProcessed);
            return;
        }
        if(open < n){
            generate(result, n, open + 1,close, unProcessed+"(");
        }
        if(close < open){
            generate(result, n, open, close + 1, unProcessed+")");
        }
    }    
        
    public List<String> generateParenthesis(int n) {
       List<String> result = new ArrayList<String>();
       generate(result, n, 0, 0, "");
       return result;
        
    }
}