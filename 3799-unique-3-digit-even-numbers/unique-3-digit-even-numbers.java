class Solution {
    public int totalNumbers(int[] digits) {
        int[] count = new int[10];
        for(int d:digits){
            count[d]++;
        }
        int result =0;
        for(int num=100;num<=998;num += 2){
            int hundreds = num/100;
            int tens = (num/10)%10;
            int ones = num%10;

            if(count[hundreds] > 0){
                count[hundreds]--;
                if(count[tens]>0){
                    count[tens]--;

                if(count[ones]>0){
                    result++;
                }
                count[tens]++;
                }
                count[hundreds]++;
            }
        }

        return result;
    }
}