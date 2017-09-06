import java.util.*;

/**
 * You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

 For example, given:
 s: "barfoothefoobarman"
 words: ["foo", "bar"]

 You should return the indices: [0,9].
 */
public class SubstringwithConcatenationofAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        if(words.length == 0 || s.length() == 0){
            return Collections.EMPTY_LIST;
        }
        int len = s.length();
        int wlen = words[0].length();
        int count = words.length;
        if(len<wlen * count){
            return Collections.EMPTY_LIST;
        }
        List<Integer> retList = new ArrayList<Integer>();
        Map<String,Integer> map = new HashMap<String,Integer>();
        Map<String,Integer> wmap = new HashMap<String,Integer>();
        for(String word : words){
           map.put(word,map.getOrDefault(word,0) + 1);
        }
        int tmpCount = 0;
        for(int i=0;i<wlen;i++){
            tmpCount = 0;
            wmap.clear();
            for(int j=i;j<len;j+=wlen){
                String str = s.substring(j,Math.min(j+wlen,len));
                if(!map.containsKey(str)){
                    tmpCount = 0;
                    wmap.clear();
                }else{
                    wmap.put(str,wmap.getOrDefault(str,0) + 1);
                    tmpCount++;
                }
                if(tmpCount < count){
                    continue;
                }
                if(tmpCount > count){
                    String preStr = s.substring( j - count * wlen,j - (count -1) * wlen);
                    wmap.put(preStr,wmap.get(preStr)-1);
                    if(wmap.get(preStr) == 0){
                        wmap.remove(preStr);
                    }
                    tmpCount--;
                }
                if(equal(wmap,map)){
                    retList.add(j - (count - 1) * wlen);

                }
            }
        }
        return retList;
    }

    public boolean equal(Map<String,Integer> map1,Map<String,Integer> map2){
       if(map1.size() != map2.size()) {
           return false;
       }
       for(Map.Entry<String,Integer> entry : map1.entrySet()){
           if(!map2.containsKey(entry.getKey()) || map2.get(entry.getKey()) != entry.getValue()){
               return false;
           }
       }
       return true;
    }
    public static void main(String[]args){
        String[]words = new String[]{"bar","foo","the"};
        new SubstringwithConcatenationofAllWords().findSubstring("barfoofoobarthefoobarman",words);
    }

}
