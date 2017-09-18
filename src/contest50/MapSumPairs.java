package contest50;

import java.util.HashMap;
import java.util.Map;

class MapSum {
    static class TrieNode{
        TrieNode[]nodeList = new TrieNode[26];
        char c;
        int value;
    }
    TrieNode root = null;
    Map<String,Integer> map = new HashMap<String,Integer>();

    public MapSum() {
        root = new TrieNode();
    }

    public void insert(String word,int value) {
        if(map.containsKey(word)){
            value = value - map.get(word);
        }
        map.put(word,value);
        char[]cs = word.toCharArray();
        TrieNode p = root;
        for(char c : cs){
            if(p.nodeList[c - 'a'] != null){
                p = p.nodeList[c - 'a'];
                p.value += value;
                continue;
            }
            TrieNode newNode = new TrieNode();
            newNode.c = c;
            newNode.value = value;
            p.nodeList[c - 'a'] = newNode;
            p = newNode;
        }
    }

    public int sum(String word) {
        char[]cs = word.toCharArray();
        TrieNode p = root;
        for(char c : cs){
            if(p.nodeList[c-'a'] == null){
                return 0;
            }
            p = p.nodeList[c - 'a'];
        }
        return p.value;
    }
    public static void main(String[]args){
        MapSum obj = new MapSum();

    }

}
