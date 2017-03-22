import java.util.List;

/**
 * @author boyang.lby
 * @date 3/21/17
 * @description
 * This algorithm takes a very long time,so just for practicing
 */
public class WordLadder {

    int ret = 0;
    boolean[][]isOneLetter = null;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        boolean[]marked = new boolean[wordList.size()];
        isOneLetter = new boolean[wordList.size()][wordList.size()];
        if(!wordList.contains(endWord)){
            return 0;
        }
        for(int i=0;i<wordList.size();i++){
            for(int j=i;j<wordList.size();j++){
                if(isOneLetterLike(wordList.get(i),wordList.get(j))){
                    isOneLetter[i][j] = true;
                    isOneLetter[j][i] = true;
                }
            }
        }
        int index = wordList.indexOf(endWord);
        _ladderLenth(beginWord,endWord,wordList,marked,1,index);
        return ret;
    }

    public void _ladderLenth(String beginWord,String endWord,List<String>wordList,boolean[]marked,int step,int j){
        for(int i = 0;i<wordList.size();i++){
            if(marked[i]){
                continue;
            }
            if(isOneLetterLike(endWord,beginWord)){
                ret = ret == 0 ? step+1 :  Math.min(step+1,ret);
                continue;
            }
            if(isOneLetter[i][j]){
                marked[i] = true;
                _ladderLenth(beginWord,wordList.get(i),wordList,marked,step + 1,i);
                marked[i] = false;
            }
        }
    }

    public boolean isOneLetterLike(String word,String word1){
        if(word.equals(word1)){
            return false;
        }
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
        return true;
    }
}
