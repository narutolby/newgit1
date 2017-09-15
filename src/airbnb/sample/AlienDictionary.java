package airbnb.sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author boyang.lby
 * @date 9/11/17
 * @description
 * There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You receive a list of words from the dictionary, wherewords are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.

For example,
Given the following words in dictionary,

[
"wrt",
"wrf",
"er",
"ett",
"rftt"
]


The correct order is: "wertf".

Note:

You may assume all letters are in lowercase.
If the order is invalid, return an empty string.
There may be multiple valid order of letters, return any one of them is fine.
 */
public class AlienDictionary {
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        int[] visited = new int[26];
        StringBuilder ret = new StringBuilder();
        Set<Integer> set = new HashSet<Integer>();
        List<Integer>[] adj = new List[26];
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            char[] chars = word.toCharArray();
            for (int j = 0; j < chars.length - 1; j++) {
                char c = chars[j];
                char s = chars[j+1];
                set.add(index(c));
                set.add(index(s));
                if(s == c){
                    continue;
                }
                List<Integer> list = null;
                if (adj[index(c)] != null){
                    list = adj[index(c)];
                }else{
                    list = new ArrayList<Integer>();
                    adj[index(c)] = list;
                }
                list.add(index(s));
            }
        }
        for(Integer i:set){
            if(visited[i] == 0){
                boolean bool = dfs(adj,visited,ret,i);
                if(!bool){
                    return "";
                }
            }
        }
        return ret.reverse().toString();
    }
    int index(char c){
        return c - 'a';
    }

    char getChar(int c){
        return (char)('a' + c);
    }
    boolean dfs(List<Integer>[]adj,int[]visited,StringBuilder sb,int c){
        visited[c] = 1;
        List<Integer> list = adj[c];
        if(list != null){
            for(Integer i:list){
                if(visited[i] == 2){
                    continue;
                }
                if(visited[i] == 1 || !dfs(adj,visited,sb,i)){
                    return false;
                }
            }
        }
        visited[c] = 2;
        sb.append(getChar(c));
        return true;
    }

    public static void main(String[]args){
        String[]words = new String[]{"wrt", "wrf", "er", "ett", "rftt"};
        long s = System.currentTimeMillis();
        for(int i = 0;i<10000;i++){
            new AlienDictionary().alienOrder1(words);
        }
        long t = System.currentTimeMillis();
        System.out.println(t - s);
    }
    public String alienOrder1(String[] words) {
        if(words == null || words.length == 0){
            return "";
        }
        List<Integer>[]adj = new List[26];
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<words.length;i++){
            char[]chars = words[i].toCharArray();
            for(int j=0;j<chars.length-1;j++){
                char s = chars[j];
                char t = chars[j+1];
                if(s == t){
                    continue;
                }
                map.put(index(s),map.getOrDefault(index(s),0));
                map.put(index(t), map.getOrDefault(index(t), 0) + 1);
                List<Integer> list = null;
                if(adj[index(s)] != null){
                    list = adj[index(s)];
                }else{
                    list = new ArrayList<Integer>();
                    adj[index(s)] = list;
                }
                list.add(index(t));
            }
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() == 0){
                queue.add(entry.getKey());
            }
        }
        StringBuilder ret = new StringBuilder();
        while(!queue.isEmpty()){
            Integer i = queue.poll();
            ret.append(getChar(i));
            List<Integer> list = adj[i];
            if(list != null){
                for(int j = 0;j<list.size();j++){
                    map.put(list.get(j),map.get(list.get(j)) - 1);
                    if(map.get(list.get(j)) == 0){
                        queue.add(list.get(j));
                    }
                }
            }
        }

        if(ret.length() != map.size()){
            return "";
        }
        return ret.toString();
    }
}
