package contest93;

import java.util.Arrays;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author boyang.lby
 * @date 7/15/18
 * @description
 */
public class Q870 {
    public int[] advantageCount(int[] A, int[] B) {
        TreeMap<Integer,Integer> treeMap = new TreeMap<Integer,Integer>();
        for(int i:A){
            treeMap.put(i,treeMap.getOrDefault(i,0)+1);
        }
        int[]ret = new int[A.length];
        for(int i=0;i<B.length;i++){
            int num = B[i];
            Integer higherKey = treeMap.higherKey(num);
            if(higherKey != null && treeMap.get(higherKey)!=0){
                ret[i] = higherKey;
                treeMap.put(higherKey,treeMap.get(higherKey)-1);
                if(treeMap.get(higherKey) == 0){
                    treeMap.remove(higherKey);
                }
            }else{
                Integer firstKey = treeMap.firstKey();
                ret[i] = firstKey;
                treeMap.put(firstKey,treeMap.get(firstKey)-1);
                if(treeMap.get(firstKey) == 0){
                    treeMap.remove(firstKey);
                }
            }
        }
        return ret;
    }
    public static void main(String[]args){
        new Q870().advantageCount(new int[]{2,0,4,1,2},new int[] {1,3,0,0,2});
    }
}
