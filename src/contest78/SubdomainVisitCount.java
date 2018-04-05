package contest78;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author boyang.lby
 * @date 4/3/18
 * @description
 */
public class SubdomainVisitCount {
    public List<String> subdomainVisits(String[] cpdomains) {
        if(cpdomains == null || cpdomains.length == 0){
            return new ArrayList<>();
        }
        Map<String,Integer> map = new HashMap<>();
        for(String str : cpdomains){
            String[] strs = str.split(" ");
            String str1 = strs[0];
            String str2 = "." + strs[1];
            char[]chars = str2.toCharArray();
            for(int i=0;i<chars.length;i++){
                 if(chars[i] == '.'){
                     String key = str2.substring(i+1);
                     map.put(key, map.getOrDefault(key, 0) + Integer.valueOf(str1));
                 }
            }
        }
        List<String> retList = new ArrayList<>();
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            retList.add(entry.getValue() + " " + entry.getKey());
        }
        return retList;
    }
}
