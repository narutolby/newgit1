import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author boyang.lby
 * @date 3/21/17
 * @description
 * This algorithm takes a very long time,so just for practicing
 */
public class WordLadder1 {


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Map<String,Integer> levelMap = new HashMap<String,Integer>();
        boolean[]marked = new boolean[wordList.size()];
        Queue<String> queue = new LinkedList<String>();
        queue.offer(beginWord);
        levelMap.put(beginWord,1);
        while(!queue.isEmpty()){
            String word = queue.poll();
            for(int i=0;i<wordList.size();i++){
                if(marked[i]){
                    continue;
                }
                if(isOneLetterDiff(word,wordList.get(i))){
                    levelMap.put(wordList.get(i),levelMap.get(word) + 1);
                    if(wordList.get(i).equals(endWord)){
                        return levelMap.get(wordList.get(i));
                    }
                    marked[i] = true;
                    queue.offer(wordList.get(i));
                }
            }
        }
        return 0;
    }



    public boolean isOneLetterDiff(String word,String word1){
        int diffCount = 0;
        for(int i=0;i<word.length();i++){
            if(word.charAt(i) == word1.charAt(i)){
                continue;
            }else{
                diffCount++;
                if(diffCount > 1){
                    return false;
                }
            }
        }
        return diffCount == 0 ? false : true;
    }
}
