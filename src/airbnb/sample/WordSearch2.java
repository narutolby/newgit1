package airbnb.sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author boyang.lby
 * @date 9/11/17
 * @description
 */
public class WordSearch2 {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> retList = new ArrayList<String>();
        TrieNode trieNode = build(words);
        Set<String> set = new HashSet<String>();
        Map<Character,List<Integer>> map = new HashMap<Character,List<Integer>>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                List<Integer> list = null;
                if(map.containsKey(board[i][j])){
                    list = map.get(board[i][j]);
                }else{
                    list = new ArrayList<Integer>();
                    map.put(board[i][j],list);
                }
                list.add(idx1(i,j,board[0].length));
            }
        }
        int[]visited = new int[board.length*board[0].length];
        TrieNode[]next = trieNode.next;
        for(int i=0;i<next.length;i++){
            if(next[i] != null){
                char c = next[i].c;
                if(map.containsKey(c)){
                    List<Integer> list = map.get(c);
                    for(Integer ii : list){
                        dfs(ii,board,next[i],set,visited);
                    }
                }
            }
        }
        retList.addAll(set);
        return retList;
    }

    int idx1(int i,int j,int m){
        return i*m + j;
    }

    void dfs(int s,char[][]b,TrieNode node,Set<String> set,int[]v){
        if(node.word != null){
            set.add(node.word);
        }
        v[s] = 1;
        int[]x = {0,0,1,-1};
        int[]y = {1,-1,0,0};
        int len = b[0].length;
        int len1 = b.length;
        for(int i=0;i<4;i++){
            int xx = s / len + x[i];
            int yy = s % len + y[i];
            if(xx>=0 && xx<len1 && yy>=0 && yy<len && v[idx1(xx,yy,len)] == 0 && node.next[idx(b[xx][yy])] != null){
                dfs(idx1(xx,yy,len),b,node.next[idx(b[xx][yy])],set,v);
            }
        }
        v[s] = 0;
    }

    public TrieNode build(String[]words){
        TrieNode root = new TrieNode();
        TrieNode p = null;
        for(int i=0;i<words.length;i++){
            String word = words[i];
            char[]chars = word.toCharArray();
            p = root;
            for(int j=0;j<chars.length;j++){
                char c = chars[j];
                TrieNode newNode = null;
                if(p.next[idx(c)] == null){
                    newNode = new TrieNode();
                    p.next[idx(c)] = newNode;
                    newNode.c = c;
                }else{
                    newNode = p.next[idx(c)];
                }
                if(j == chars.length - 1){
                    newNode.word = word;
                }
                p = p.next[idx(c)];
            }
        }
        return root;
    }
    int idx(char c){
        return c- 'a';
    }

    static class TrieNode{
        char c;
        String word;
        TrieNode[] next = new TrieNode[26];
    }
    public static void main(String[]args){
        new WordSearch2().findWords(new char[][]{{'a'}},new String[]{"a"});
    }
}
