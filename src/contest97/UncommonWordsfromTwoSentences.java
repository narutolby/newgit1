package contest97;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author boyang.lby
 * @date 8/12/18
 * @description
 */
public class UncommonWordsfromTwoSentences {
    public String[] uncommonFromSentences(String A, String B) {
        Map<String,Integer> map = new HashMap<>();
        String[]as = A.split(" ");
        String[]bs = B.split(" ");
        for(String str:as){
            map.put(str,map.getOrDefault(str,0) + 1);
        }
        for(String str:bs){
            map.put(str,map.getOrDefault(str,0) + 1);
        }
        List<String> list = new ArrayList<>();
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            if(entry.getValue() == 1){
                list.add(entry.getKey());
            }
        }
        return list.toArray(new String[list.size()]);
    }
}
