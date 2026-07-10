class Solution {
    public int mySqrt(int x) {
                if(x<=1) return x;
       int left=1;int right=x;int res=0;
       while(left<=right){
        int mid = left+(right-left)/2;
        long square = (long) mid*mid;
        if(square==x){
            return  mid;
        }

        else if(square>x) right = mid-1;
        else{
            res = mid;
            left = mid+1;
        }
       }
       return res;
    }
}