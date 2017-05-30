package contest34;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author boyang.lby
 * @date 5/28/17
 * @description
 */
public class MinimumIndexSumofTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> retList = new ArrayList<String>();
        if(list1 == null || list1.length == 0 || list2 == null || list2.length == 0){
            return retList.toArray(new String[]{});
        }
        int min = Integer.MAX_VALUE;
        Map<String,Integer> map = new HashMap<String,Integer>();
        for(int i = 0;i< list1.length;i++){
            map.putIfAbsent(list1[i],i);
        }
        for(int i=0;i<list2.length;i++){
            if(map.containsKey(list2[i])){
                int sum = map.get(list2[i]) + i;
                if(sum < min){
                    min = sum;
                    retList.clear();
                    retList.add(list2[i]);
                }else if(sum == min){
                    retList.add(list2[i]);
                }
            }
        }
        return retList.toArray(new String[]{});

    }
}
