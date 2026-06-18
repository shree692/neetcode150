class Solution {
    public boolean checkInclusion(String s1, String s2) {
     int s1len = s1.length();
     int s2len = s2.length();
     int count1[] = new int[26];
     int count2[] = new int[26];
     if(s1len>s2len) return false;
     for(char c:s1.toCharArray()){
        count1[c-'a']++;
     }
     
     for(int i=0;i<s2len;i++){
        count2[s2.charAt(i)-'a']++;
        if(i>=s1len){
            count2[s2.charAt(i-s1len)-'a']--;
        }
        if(match(count1,count2)) return true;
     }
     return false;
    }
    public boolean match(int[] count1,int[] count2){
        for(int i=0;i<26;i++){
            if(count1[i]!=count2[i]) return false;
        }
        return true;
    }
}