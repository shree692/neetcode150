class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0){
            return new ArrayList();
        }
        Map<String,List> map = new HashMap<>();
        int freq[] = new int[26];
        for(String s: strs){
            Arrays.fill(freq,0);
            for(char c: s.toCharArray()){
                freq[c-'a']++;

            }
            StringBuilder sb = new StringBuilder("");
            for(int i = 0;i<26;i++){
                sb.append("#");
                sb.append(freq[i]);
            }
            String key = sb.toString();
            if(!map.containsKey(key)){
                map.put(key,new ArrayList());
            }
            map.get(key).add(s);
        }
        return new ArrayList(map.values());
    }
}