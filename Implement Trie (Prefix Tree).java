import java.util.*;

class Trie {
    
    TrieNode root; 
    
    public Trie() {
        root = new TrieNode();
    }
    
    
    public void insert(String word) {
        
        TrieNode currentNode = root;
        
        System.out.println(currentNode);
        
        for(char c : word.toCharArray()){
            currentNode = currentNode.getChildren().computeIfAbsent(c,ch -> new TrieNode());
        }
        currentNode.setEndWordCheck(true);
        
    }
    
    public boolean search(String word) {
        TrieNode currentNode = root;
        
        for(char c : word.toCharArray()){
            TrieNode Node = currentNode.getChildren().get(c);
            if(Node == null){
                return false;
            }
            
            currentNode = Node;
        }
        
        return currentNode.isEndWordCheck();
    }
    
    public boolean startsWith(String prefix) {
        
        TrieNode currentNode = root;
        
        for(char c : prefix.toCharArray()){
            TrieNode Node = currentNode.getChildren().get(c);
            // TrieNode Node = currentNode.getChildren().containsKey(c);
            if(Node == null){
                return false;
            }
            
            currentNode = Node;
        }
        
        return true;
    }
    
    class TrieNode{
        private HashMap<Character, TrieNode> children = new HashMap<>();
        private boolean endWordCheck;
        
        HashMap<Character, TrieNode> getChildren() {
            return children;
        }
        
        boolean isEndWordCheck(){
            return endWordCheck;
        }
        
        void setEndWordCheck(boolean endWordCheck){
            this.endWordCheck = endWordCheck;
        }
        
        
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
 