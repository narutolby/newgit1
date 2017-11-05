package contest57;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author boyang.lby
 * @date 11/5/17
 * @description
 */
public class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<Integer, TreeSet<String>> map = new HashMap<>();
        Map<String, Integer> map1 = new HashMap();
        int[] table = new int[accounts.size()];
        for (int i = 0; i < table.length; i++) {
            table[i] = i;
        }
        for (int i = 0; i < accounts.size(); i++) {
            TreeSet<String> treeSet = new TreeSet<>();
            List<String> list = accounts.get(i);
            for (int j = 1; j < list.size(); j++) {
                treeSet.add(list.get(j));
                if (map1.containsKey(list.get(j))) {
                    union(table, i, map1.get(list.get(j)));
                }
                map1.put(list.get(j), i);
            }
            map.put(i, treeSet);
        }
        for (int i = 0; i < table.length; i++) {
            int father = getFather(table, i);
            if (i == father) {
                continue;
            }
            map.get(father).addAll(map.get(i));
            map.remove(i);
        }
        List<List<String>> retList = new ArrayList<>();
        for (Map.Entry<Integer, TreeSet<String>> entry : map.entrySet()) {
            List<String> list = new ArrayList<>();
            list.add(accounts.get(entry.getKey()).get(0));
            list.addAll(entry.getValue());
            retList.add(list);
        }
        return retList;
    }

    public void union(int[] table, int i, int j) {
        table[getFather(table, i)] = getFather(table, j);
    }

    public int getFather(int[] table, int i) {
        if (table[i] == i) {
            return i;
        } else {
            return table[i] = getFather(table, table[i]);
        }
    }

    public static void main(String[] args) {
        List<List<String>> list = new ArrayList<>();
        list.add(Arrays.asList("David", "David0@m.co", "David1@m.co"));
        list.add(Arrays.asList("David", "David3@m.co", "David4@m.co"));
        list.add(Arrays.asList("David", "David4@m.co", "David5@m.co"));
        list.add(Arrays.asList("David", "David2@m.co", "David3@m.co"));
        list.add(Arrays.asList("David", "David1@m.co", "David2@m.co"));
        new AccountsMerge().accountsMerge1(list);
    }


    public List<List<String>> accountsMerge1(List<List<String>> accounts) {
        int n = accounts.size();
        DJSet ds = new DJSet(n);
        List<Set<String>> sets = new ArrayList<>();
        for(List<String> li : accounts){
            Set<String> set = new HashSet<>();
            for(int i = 1;i < li.size();i++)set.add(li.get(i));
            sets.add(set);
        }
        for(int i = 0;i < n;i++){
            for(int j = i+1;j < n;j++){
                if(accounts.get(i).get(0).equals(accounts.get(j).get(0)) &&
                    !Collections.disjoint(sets.get(i), sets.get(j))
                    ){
                    ds.union(i, j);
                }
            }
        }
        for(int i = 0;i < n;i++){
            int r = ds.root(i);
            sets.get(r).addAll(sets.get(i));
        }
        List<List<String>> ret = new ArrayList<>();
        for(int i = 0;i < n;i++){
            if(ds.upper[i] < 0){
                List<String> row = new ArrayList<>(sets.get(i));
                Collections.sort(row);
                row.add(0, accounts.get(i).get(0));
                ret.add(row);
            }
        }
        return ret;
    }
}
//Disjoint Set
//http://www.cnblogs.com/shadowwalker9/p/5999029.html
class DJSet {
    public int[] upper;

    public DJSet(int n) {
        upper = new int[n];
        Arrays.fill(upper, -1);
    }

    public int root(int x) { return upper[x] < 0 ? x : (upper[x] = root(upper[x]));}

    public boolean equiv(int x, int y) { return root(x) == root(y);}

    //数组中元素为负数的表示是根,其中,负数的绝对值是所在树的节点数量
    public boolean union(int x, int y) {
        x = root(x);
        y = root(y);
        if (x != y) {
            if (upper[y] < upper[x]) {
                int d = x;
                x = y;
                y = d;
            }
            upper[x] += upper[y];
            upper[y] = x;
        }
        return x == y;
    }

    public int count() {
        int ct = 0;
        for (int u : upper) { if (u < 0) { ct++; } }
        return ct;
    }
}
