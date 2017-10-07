package google;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author boyang.lby
 * @date 10/5/17
 * @description
 * Given two arrays of length m and n with digits 0-9 representing two numbers. Create the maximum number of length k <= m + n from digits of the two. The relative order of the digits from the same array must be preserved. Return an array of the k digits. You should try to optimize your time and space complexity.

Example 1:
nums1 = [3, 4, 6, 5]
nums2 = [9, 1, 2, 5, 8, 3]
k = 5
return [9, 8, 6, 5, 3]

Example 2:
nums1 = [6, 7]
nums2 = [6, 0, 4]
k = 5
return [6, 7, 6, 0, 4]

Example 3:
nums1 = [3, 9]
nums2 = [8, 9]
k = 3
return [9, 8, 9]
 */
public class CreateMaximumNumber {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[]ret = new int[k];
        if(nums1 == null && nums2 == null){
            return ret;
        }
        if(nums1.length == 0 && nums2.length == 0){
            return ret;
        }
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        };
        TreeMap<Integer,TreeSet<Integer>> treeMap1 = new TreeMap<Integer,TreeSet<Integer>>(comparator);
        TreeMap<Integer,TreeSet<Integer>> treeMap2 = new TreeMap<Integer,TreeSet<Integer>>(comparator);
        addAll(treeMap1,nums1);
        addAll(treeMap2,nums2);
        int s1 = 0,s2 = 0,len1 = nums1.length,len2 = nums2.length;
        ret = helper(treeMap1,treeMap2,s1,s2,k,len1,len2);
        return ret;
    }

    public int[] helper(TreeMap<Integer,TreeSet<Integer>> treeMap1,TreeMap<Integer,TreeSet<Integer>> treeMap2,int s1,int s2,int k,int len1,int len2){
        int[]ret = new int[k];
        if(k == 0){
            return  ret;
        }
        Integer max1 = next(treeMap1,s1,s2,k,len1,len2);
        Integer max2 = next(treeMap2,s2,s1,k,len2,len1);
        if(max1 != null && max2 != null){
            if(max1>max2){
                ret[0] = max1;
                s1 = treeMap1.get(max1).first()+1;
            }else if(max1<max2){
                ret[0] = max2;
                s2 = treeMap2.get(max2).first() + 1;
            }else{
                ret[0] = max1;
                int tmp1 = treeMap1.get(max1).first()+1;
                int tmp2 = treeMap2.get(max1).first()+1;
                int[]nt1 = helper(clone(treeMap1),clone(treeMap2),tmp1,s2,k-1,len1,len2);
                int[]nt2 = helper(treeMap1,treeMap2,s1,tmp2,k-1,len1,len2);
                int[] nt = compare(nt1,nt2);
                copy(ret,1,nt);
                return ret;
            }
        }else if(max1 != null){
            ret[0] = max1;
            s1 = treeMap1.get(max1).first()+1;
        }else if(max2 != null){
            ret[0] = max2;
            s2 = treeMap2.get(max2).first()+1;
        }
        int[] nt = helper(treeMap1,treeMap2,s1,s2,k-1,len1,len2);
        copy(ret,1,nt);
        return ret;
    }

    public TreeMap<Integer,TreeSet<Integer>> clone(TreeMap<Integer,TreeSet<Integer>> treeMap){
        TreeMap<Integer,TreeSet<Integer>> ret = new TreeMap<Integer,TreeSet<Integer>>();
        for(Map.Entry<Integer,TreeSet<Integer>> entry : treeMap.entrySet()){
            TreeSet<Integer> treeSet = new TreeSet<>();
            treeSet.addAll(entry.getValue());
            ret.put(entry.getKey(),treeSet);
        }
        return ret;
    }

    public void copy (int[]nums1,int s,int[]nums2){
        for(int i=0;i<nums2.length;i++){
            nums1[s] = nums2[i];
            s++;
        }
    }

    public int[] compare(int[]nt1,int[]nt2){
        for(int i=0;i<nt1.length;i++){
            if(nt1[i]<nt2[i]){
                return nt2;
            }else{
                return nt1;
            }
        }
        return nt1;
    }


    public Integer next(TreeMap<Integer,TreeSet<Integer>> treeMap,int s1,int s2,int k,int len1,int len2){
        for(Map.Entry<Integer,TreeSet<Integer>> entry:treeMap.entrySet() ){
            TreeSet<Integer> treeSet = entry.getValue();
            for(Iterator<Integer> iterator = treeSet.iterator();iterator.hasNext();){
                Integer ii = iterator.next();
                if(ii < s1){
                    iterator.remove();
                }else if(len1 - ii + len2 - s2 >= k){
                   return entry.getKey();
                }
            }
        }
        return null;
    }
    public void addAll(TreeMap<Integer,TreeSet<Integer>> treeMap,int[]nums){
        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            TreeSet<Integer> treeSet = null;
            if(treeMap.containsKey(num)){
                treeSet = treeMap.get(num);
            }else{
                treeSet = new TreeSet<>();
                treeMap.put(num,treeSet);
            }
            treeSet.add(i);
        }
    }
    public static void main(String[]args){
        //new CreateMaximumNumber().maxNumber(new int[]{3, 4, 6, 5},new int[]{9, 1, 2, 5, 8, 3},5);
        //new CreateMaximumNumber().maxNumber(new int[]{6, 7},new int[]{6,0,4},5);
        //new CreateMaximumNumber().maxNumber(new int[]{8, 9},new int[]{3,9},3);
        //new CreateMaximumNumber().maxNumber(new int[]{5,5,1},new int[]{4,0,1},3);
        new CreateMaximumNumber().maxNumber(new int[]{5,1,0},new int[]{5,2,1},3);
    }
}
