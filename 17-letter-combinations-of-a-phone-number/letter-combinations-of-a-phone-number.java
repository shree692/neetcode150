class Solution {
    List<String> ans = new ArrayList<>();
    String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){return ans;}
        backtrack(digits,0,"");
        return ans;
    }
    void backtrack(String digits,int index,String curr){
        if(index == digits.length()){
            ans.add(curr);
            return;

        }
        String letter = map[digits.charAt(index)-'0'];
        for(char c:letter.toCharArray()){
            backtrack(digits,index+1,curr+c);
        }
    }
}
