class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length()) return "";
        HashMap<Character,Integer> scount = new HashMap<>();
        HashMap<Character,Integer> tcount = new HashMap<>();
        for(char c:t.toCharArray()){
            tcount.put(c,tcount.getOrDefault(c,0)+1);
        }
        int need=tcount.size();
        int left=0;int start=0;int have=0;
        int minlen = Integer.MAX_VALUE;
        for(int r=0;r<s.length();r++){
            char c=s.charAt(r);
            scount.put(c,scount.getOrDefault(c,0)+1);
            if(tcount.containsKey(c) && scount.get(c).intValue()==tcount.get(c).intValue()){
                have++;
            }
            while(need==have){
                int w = r-left+1;
                if(w<minlen){
                    minlen = w;
                    start=left;
             }
            
            char lchar = s.charAt(left);
            scount.put(lchar,scount.get(lchar)-1);
            if(tcount.containsKey(lchar) && scount.get(lchar)<tcount.get(lchar)){
                have--;
            }
            left++;
        }
        }
    return minlen == Integer.MAX_VALUE?"":s.substring(start,start+minlen);
    }
}