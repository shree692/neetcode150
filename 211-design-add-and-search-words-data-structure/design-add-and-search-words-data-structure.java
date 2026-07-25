class TrieNode{
    TrieNode[] children;
    boolean isEnd;
    TrieNode(){
        children = new TrieNode[26];
    }
}
class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for(char c:word.toCharArray()){
            int index = c-'a';
            if(node.children[index] == null){
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(word,0,root);
    }

    boolean dfs(String word,int index,TrieNode node){
        if(index == word.length()){
            return node.isEnd;

        }
        char c=word.charAt(index);
        
        if(c!='.'){
         int i=c-'a';
         if(node.children[i] == null) return false;
         return dfs(word,index+1,node.children[i]);
        }
        for(TrieNode n : node.children){
            if(n!=null && dfs(word,index+1,n)){
                return true;
            }
        }
        return false;
    }
}
