import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author boyang.lby
 * @date 9/23/17
 * @description
 */
public class WordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<String>();
        List<String> retList = new ArrayList<String>();
        set.addAll(wordDict);
        if(set.contains(s)){
            retList.add(s);
            return retList;
        }
        Map<Integer,List<StringBuilder>> map = new HashMap<Integer,List<StringBuilder>>();
        List<StringBuilder> list = new ArrayList<StringBuilder>();
        list.add(new StringBuilder());
        map.put(0,list);
        for(int i =1;i<=s.length();i++){
            for(int j=i;j>=1;j--){
                String substr = s.substring(j-1,i);
                if(map.containsKey(j-1) && set.contains(substr)){
                    List<StringBuilder> tmp = null;
                    if(map.containsKey(i)){
                        tmp = map.get(i);
                    }else{
                        tmp = new ArrayList<StringBuilder>();
                        map.put(i,tmp);
                    }
                    for(StringBuilder sb : map.get(j-1)){
                        tmp.add(new StringBuilder(sb.toString()).append(" ").append(substr));
                    }
                }
            }
        }
        for(StringBuilder ll : map.get(s.length())){
            retList.add(ll.toString().trim());
        }
        return retList;
    }
}
