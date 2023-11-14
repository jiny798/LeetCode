import java.util.*;
class Solution {
    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        Map<Integer, Trie> map1 = new HashMap<>();
        Map<Integer, Trie> map2 = new HashMap<>();
        
        for(int i = 1 ; i <= 10000 ; i++){
            map1.put(i,new Trie());
            map2.put(i,new Trie());
        }
        for(int i = 0 ; i < words.length ; i++){
            Trie trie1 = map1.get(words[i].length());
            trie1.addWord(words[i]);            
            String reverse = reverseString(words[i]);            
            Trie trie2 = map2.get(words[i].length());
            // System.out.println(trie2 + " -- ");
            trie2.addWord(reverse);
        }
        
        for(int i = 0 ; i < queries.length ; i++){
            String q = queries[i];
            Trie trie1 = map1.get(q.length());
            Trie trie2 = map2.get(q.length());
            int n = 0 ;
            if(q.charAt(0) == '?'){ // 시작부터 물음표면
                String reverse = reverseString(q);    
                n= trie2.search(reverse);
            }else{
                n=trie1.search(q);
            }
            answer[i] = n ;
        }     
        return answer;
    }
    
    public String reverseString(String str){
        char[] chars = str.toCharArray();
        String answer = "";
        for(int i = chars.length-1 ; i >= 0 ; i--){
            answer += String.valueOf(chars[i]);
        }
        return answer;
    }
    
    class TrieNode {
        Map<Character,TrieNode> childNodes = new HashMap<>();
        int count = 0;
        boolean isLastChar;
    }
    
    class Trie {
        private TrieNode rootNode;
        public Trie() {
            rootNode = new TrieNode();
        }
        public void addWord(String word) {
            TrieNode thisNode = this.rootNode;
            for(int i = 0 ; i < word.length() ; i++){
                thisNode.count++;
                thisNode = thisNode.childNodes.computeIfAbsent(word.charAt(i), c -> new TrieNode());               
            }
            thisNode.isLastChar = true;
        }
    
        public int search(String word) {
            TrieNode thisNode = this.rootNode;
            for(int i = 0 ; i < word.length() ; i++){
                char c = word.charAt(i);
                if(c=='?'){
                    return thisNode.count;
                }
                TrieNode node = thisNode.childNodes.get(c);     
                if(node == null){
                    return 0;
                }
                thisNode = node;
            }
            
            if(thisNode.isLastChar){
                return 1;
            }
            return 0;
        }
    }
}