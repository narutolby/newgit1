package contest57;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author boyang.lby
 * @date 11/5/17
 * @description
 */
public class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<Integer,TreeSet<String>> map = new HashMap<>();
        Map<String,Integer> map1 = new HashMap();
        int[]table = new int[accounts.size()];
        for( int i=0;i<table.length;i++){
            table[i] = i;
        }
        for(int i=0;i<accounts.size();i++){
            TreeSet<String> treeSet = new TreeSet<>();
            List<String> list =accounts.get(i);
            for(int j=1;j<list.size();j++){
                treeSet.add(list.get(j));
                if(map1.containsKey(list.get(j))){
                    union(table,i,map1.get(list.get(j)));
                }
                map1.put(list.get(j),i);
            }
            map.put(i,treeSet);
        }
        for(int i=0;i<table.length;i++){
            int father = getFather(table,i);
            if(i == father){
                continue;
            }
            map.get(father).addAll(map.get(i));
            map.remove(i);
        }
        List<List<String>> retList = new ArrayList<>();
        for(Map.Entry<Integer,TreeSet<String>> entry : map.entrySet()){
            List<String> list = new ArrayList<>();
            list.add(accounts.get(entry.getKey()).get(0));
            list.addAll(entry.getValue());
            retList.add(list);
        }
        return retList;
    }

    public void union(int[]table,int i ,int j){
       table[getFather(table,i)] = getFather(table,j);
    }

    public int getFather(int[]table,int i){
        if(table[i] == i){
            return i;
        }else{
            return table[i] = getFather(table,table[i]);
        }
    }




    public static void main(String[]args){
        List<List<String>> list = new ArrayList<>();
        list.add(Arrays.asList("David", "David0@m.co", "David1@m.co"));
        list.add(Arrays.asList("David","David3@m.co","David4@m.co"));
        list.add(Arrays.asList("David","David4@m.co","David5@m.co"));
        list.add(Arrays.asList("David","David2@m.co","David3@m.co"));
        list.add(Arrays.asList("David","David1@m.co","David2@m.co"));
        new AccountsMerge().accountsMerge(list);
    }
}
