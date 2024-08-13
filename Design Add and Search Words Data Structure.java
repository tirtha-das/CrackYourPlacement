class TrieNode {
    boolean isEndOfWord;
    TrieNode[] children;

    public TrieNode() {
        isEndOfWord = false;
        children = new TrieNode[26];
    }
}

class WordDictionary {
TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode temp = root;
        char[] chars = word.toCharArray();
        for(char c: chars) {
            if(temp.children[c-'a'] == null) {
                temp.children[c-'a'] = new TrieNode();
            }
            temp = temp.children[c-'a'];
        }

        temp.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode temp = root;
        for(int i=0; i < word.length();i++) {
            char c  = word.charAt(i);
            if(c=='.') {
                for(int j=0;j<26;j++) {
                    if(temp.children[j]!=null && search(word.substring(0,i) + (char)(j+'a') + word.substring(i+1))) return true;
                }

                return false;

            } else {
                if(temp.children[c-'a']!= null) {
                    temp = temp.children[c-'a'];
                } else{
                    temp = null;
                    break;
                }
            }
        }

        return temp!=null && temp.isEndOfWord;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */