/**
 * @author boyang.lby
 * @date 6/27/17
 * @description
 */
public class ImplementTrie {
    static class TrieNode{
        TrieNode[]nodeList = new TrieNode[26];
        char c;
        int count = 0;
    }
    TrieNode root = null;
    /** Initialize your data structure here. */
    public ImplementTrie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[]cs = word.toCharArray();
        TrieNode p = root;
        for(char c : cs){
            if(p.nodeList[c - 'a'] != null){
                p = p.nodeList[c - 'a'];
                continue;
            }
            TrieNode newNode = new TrieNode();
            newNode.c = c;
            p.nodeList[c - 'a'] = newNode;
            p = newNode;
        }
        p.count ++;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[]cs = word.toCharArray();
        TrieNode p = root;
        for(char c : cs){
            if(p.nodeList[c-'a'] == null){
                return false;
            }
            p = p.nodeList[c - 'a'];
        }
        if(p.count != 0){
            return true;
        }else{
            return false;
        }

    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[]cs = prefix.toCharArray();
        TrieNode p = root;
        for(char c : cs){
            if(p.nodeList[c-'a'] == null){
                return false;
            }
            p = p.nodeList[c - 'a'];
        }
        return true;
    }
}
