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
 * @author boyang.lby
 * @date 3/23/17
 * @description dfs + backtracking
 */
public class WordLadderIII {

    List<List<String>> retList = new ArrayList<>();
    Set<String> markedSet = new HashSet<>();
    int shortestPath = Integer.MAX_VALUE;
    Map<String, Integer> levelMap = new HashMap<String, Integer>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Stack<String> stack = new Stack<>();
        wordList.remove(beginWord);
        Set<String> wordSet = new HashSet<>(wordList);
        shortestPath = ladderLength(beginWord,endWord,wordList);
        /*if(shortestPath == 0){
            return retList;
        }*/
        stack.push(beginWord);
        dfs(beginWord, endWord, 1, stack, wordSet);
        return retList;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> marked = new HashSet<>();
        Queue<String> queue = new LinkedList<String>();
        queue.offer(beginWord);
        levelMap.put(beginWord, 1);
        while (!queue.isEmpty()) {
            String word = queue.poll();
            char[] sourceWordArray = word.toCharArray();
            for (int i = 0; i < sourceWordArray.length; i++) {
                char tmpChar = sourceWordArray[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == tmpChar) {
                        continue;
                    }
                    sourceWordArray[i] = c;
                    String tmpWord = new String(sourceWordArray);
                    if(wordSet.contains(tmpWord) && !marked.contains(tmpWord)){
                        levelMap.put(tmpWord, levelMap.get(word) + 1);
                        /*if (tmpWord.equals(endWord)) {
                            //return levelMap.get(tmpWord);
                            shortestPath = levelMap.get(tmpWord);
                        }*/
                        marked.add(tmpWord);
                        queue.offer(tmpWord);
                    }
                }
                sourceWordArray[i] = tmpChar;
            }
        }
        return 0;
    }

    public void dfs(String sourceWord, String targetWord, int path, Stack<String> stack, Set<String> wordSet) {
        if (path > levelMap.get(sourceWord)) {
            return;
        }
        char[] sourceWordArray = sourceWord.toCharArray();
        for (int i = 0; i < sourceWordArray.length; i++) {
            char tmpChar = sourceWordArray[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == tmpChar) {
                    continue;
                }
                sourceWordArray[i] = c;
                String word = new String(sourceWordArray);
                if (wordSet.contains(word) && !markedSet.contains(word)) {
                    markedSet.add(word);
                    stack.push(word);
                    try {
                        if (word.equals(targetWord)) {
                            if (path == levelMap.get(targetWord)) {
                                List<String> elementList = new ArrayList<>();
                                elementList.addAll(stack);
                                retList.add(elementList);
                                return;
                            }
                        } else {
                            dfs(word, targetWord, path + 1, stack, wordSet);
                        }
                    } finally {
                        stack.pop();
                        markedSet.remove(word);
                    }
                }
            }
            sourceWordArray[i] = tmpChar;

        }
    }

    public boolean isOneLetterDiff(String word, String word1) {
        int diffCount = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == word1.charAt(i)) {
                continue;
            } else {
                diffCount++;
                if (diffCount > 1) {
                    return false;
                }
            }
        }
        return diffCount == 0 ? false : true;
    }

    public static void main(String[]args){
        String beginword= "a";
        String endword= "c";
        List<String> wordList = new ArrayList<String>();
        wordList.add("a");
        wordList.add("b");
        wordList.add("c");
        new WordLadderIII().findLadders(beginword,endword,wordList);
    }
}
