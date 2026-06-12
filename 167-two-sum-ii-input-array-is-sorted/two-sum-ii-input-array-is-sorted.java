class Solution {
    static int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        int[] out = new int[2];
        while(l<r){
            int sum = numbers[l] + numbers[r];
            if(sum == target){
                out[0] = l+1;
                out[1] = r+1;
                return out;
            }
            else if(sum < target){
            l++;}
            else{
            r--;}
        }
        return new int[]{-1,-1};
    }
}