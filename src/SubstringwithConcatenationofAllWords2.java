import java.util.*;

public class SubstringwithConcatenationofAllWords2 {
    public List<Integer> findSubstring(String s, String[] words) {
        if(s == null || s.length() == 0 || words == null || words.length == 0){
            return Collections.emptyList();
        }
        Map<String,Integer> map  = new HashMap<>();
        Map<String,Integer> wmap = new HashMap<>();
        for(String word : words){
            map.put(word,map.getOrDefault(word,0) + 1);
        }
        int count  = words.length;
        int wlen = words[0].length();
        List<Integer> ret = new ArrayList<>();
        for(int i=0;i<wlen;i++){
            int tmpCount = 0;
            wmap.clear();
            for(int j=i;j<s.length() + wlen;j+=wlen){
                if(tmpCount == count){
                    ret.add(j - tmpCount * wlen);
                }
                if(j == s.length() + wlen - 1){
                    break;
                }
                String word = s.substring(j,Math.min(s.length(),j+wlen));
                if(!map.containsKey(word)){
                    tmpCount = 0;
                    wmap.clear();
                }else if(map.containsKey(word)){
                    if(wmap.getOrDefault(word,0)<map.get(word)){
                        wmap.put(word,wmap.getOrDefault(word,0) + 1);
                        tmpCount++;
                    }else{
                        int mm  = j - tmpCount * wlen;
                        String word1 = s.substring(mm,mm+wlen);
                        while(!word1.equals(word)){
                            wmap.put(word1,wmap.get(word1)-1);
                            tmpCount--;
                            mm+=wlen;
                            word1 = s.substring(mm,mm+wlen);
                        }
                    }
                }

            }
        }
        return ret;
    }

    public static void main(String[]args){
        new SubstringwithConcatenationofAllWords2().findSubstring("wordgoodgoodgoodbestword" ,new String[]{"word","good","best","good"});
    }
}
