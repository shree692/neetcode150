class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        int num=0;
        int xx = x;
        while(x!=0){
            int d = x%10;
            num = num*10+ d;
            x = x/10;
        }
        if(num==xx){return true;}
        else{
            return false;
        }
    }
}