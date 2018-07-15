package contest81;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author boyang.lby
 * @date 4/22/18
 * @description
 */
public class ShortEncodingofWords {
    static class TrieNode{
        TrieNode[]nodeList = new TrieNode[26];
        char c;
        int count = 0;
    }
    TrieNode root = new TrieNode();


    public void insert(String word) {
        char[] cs = new StringBuilder(word).reverse().toString().toCharArray();
        TrieNode p = root;
        for (char c:cs) {
            if (p.nodeList[c - 'a'] != null) {
                p = p.nodeList[c - 'a'];
                continue;
            }
            TrieNode newNode = new TrieNode();
            newNode.c = c;
            p.nodeList[c - 'a'] = newNode;
            p = newNode;
        }
        root.nodeList[cs[0]-'a'].count = Math.max(root.nodeList[cs[0]-'a'].count,word.length());
    }

    public int minimumLengthEncoding(String[] words) {
        if(words.length  == 1){
            return words[0].length() + 1;
        }
        for(String word: words){
            insert(word);
        }
        int ret = 0;
        for(TrieNode t : root.nodeList){
            if(t != null){
                ret += t.count + 1;
            }
        }
        return ret;
    }

    public static void main(String[]args){
        System.out.println(new ShortEncodingofWords().minimumLengthEncoding(new String[] {"time", "me", "bell"}));
    }
}
