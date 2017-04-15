/**
 * @author boyang.lby
 * @date 4/2/17
 * @description
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 * the five times to try
 */
public class WordLadderIIIII {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> retList = new ArrayList<>();
        if(wordList.isEmpty()){
            return retList;
        }
        Map<String,List<String>> parantMap = new HashMap<>();
        Map<String,Integer> shortestMap = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        Set<String> wordSet = new HashSet<>();
        wordSet.addAll(wordList);
        wordSet.remove(beginWord);
        shortestMap.put(beginWord, 0);
        queue.add(beginWord);

        while(!queue.isEmpty()){
            String word = queue.poll();
            char[] chars = word.toCharArray();
            for(int i=0;i<chars.length;i++){
                char tmpChar = chars[i];
                for(char c = 'a';c<='z';c++){
                    if(c == tmpChar){
                        continue;
                    }else{
                        chars[i] = c;
                    }
                    String adjcentWord = new String(chars);
                    if(wordSet.contains(adjcentWord)){
                        if(!shortestMap.containsKey(adjcentWord)){
                            shortestMap.put(adjcentWord,shortestMap.get(word)+1);
                            List<String> parentList = new ArrayList<>();
                            parentList.add(word);
                            parantMap.put(adjcentWord,parentList);
                            queue.offer(adjcentWord);
                        }else{
                            if(shortestMap.get(word) + 1 == shortestMap.get(adjcentWord)){
                                parantMap.get(adjcentWord).add(word);
                            }
                        }
                    }
                }
                chars[i] = tmpChar;
            }
        }
        if(!shortestMap.containsKey(endWord)){
            return retList;
        }
        Stack<String> stack = new Stack<>();
        stack.push(endWord);
        recursivePrint(parantMap, endWord, retList, stack);
        return retList;
    }

    public void recursivePrint(Map<String,List<String>> parentMap,String word,List<List<String>> retList,Stack<String> stack){
        if(!parentMap.containsKey(word)){
            LinkedList<String> linkedList = new LinkedList<>();
            for(int i=0;i<stack.size();i++){
               linkedList.addFirst(stack.get(i));
            }
            retList.add(linkedList);
            return;
        }
        List<String> parentList = parentMap.get(word);
        for(String parentWord : parentList){
            stack.push(parentWord);
            recursivePrint(parentMap, parentWord, retList, stack);
            stack.pop();
        }
    }
}
