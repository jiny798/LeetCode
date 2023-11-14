import java.util.*;
class WordDictionary {
    class TrieNode {
        Map<Character, TrieNode> childNodes = new HashMap<>();
        boolean isLastChar;
    }
    private TrieNode rootNode;
    public WordDictionary() {
        rootNode = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode thisNode = this.rootNode;
        for(int i = 0 ; i < word.length() ; i++){
            thisNode = thisNode.childNodes.computeIfAbsent(word.charAt(i), c -> new TrieNode());
        }
        thisNode.isLastChar = true;
    }
    
    public boolean search(String word) {
        TrieNode thisNode = this.rootNode;
        char[] charArr = word.toCharArray();
        for(int i = 0 ; i < word.length() ; i++){
            char c = word.charAt(i);
            TrieNode node = thisNode.childNodes.get(c);     
            if(c=='.'){
                for(Character ch : thisNode.childNodes.keySet()){
                    charArr[i] = ch;
                    String newWord = "";
                    for(int j = 0 ; j < charArr.length ; j++){
                        newWord += String.valueOf(charArr[j]);
                    }                
                    if(search(newWord)){
                        return true;
                    }
                }
            }
            
            if(node == null){
                return false;
            }
            thisNode = node;
        }
        return thisNode.isLastChar;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */