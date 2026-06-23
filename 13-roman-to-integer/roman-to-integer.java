class Solution {
    public int romanToInt(String s) {
        int sum =0;
        for(int i=0;i<s.length();i++){
            int ch = val(s.charAt(i));
            if(i<s.length()-1 && ch<val(s.charAt(i+1))){
                sum -= ch;

            }
            else{
            sum += ch;}
        }
        return sum;
    }
    private int val(char c){
        switch(c){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return 0;
    }

}