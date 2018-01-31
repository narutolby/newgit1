import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author boyang.lby
 * @date 1/30/18
 * @description
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0){
            return Collections.EMPTY_LIST;
        }
        Map<String,List<String>> map = new HashMap<String,List<String>>();
        for(String str : strs){
            char[]chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> list = null;
            if(!map.containsKey(key)){
                list = new ArrayList<String>();
                map.put(key,list);
            }else{
                list = map.get(key);
            }
            list.add(str);
        }
        return new ArrayList(map.values());
    }

    public static void main(String[]args){
        new GroupAnagrams().groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
    }
}
