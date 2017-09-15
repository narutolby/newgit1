import java.util.TreeMap;

/**
 * @author boyang.lby
 * @date 9/11/17
 * @description
 */
public class ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums == null || nums.length == 0 || k == 0){
            return false;
        }
        TreeMap<Integer,Integer> treeMap = new TreeMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(i>k){
                int pre = nums[i-k-1];
                if(treeMap.containsKey(pre)){
                    if(treeMap.get(pre) != 1){
                        treeMap.put(pre,treeMap.get(pre)-1);
                    }else{
                        treeMap.remove(pre);
                    }
                }
            }
            if(!treeMap.isEmpty()){
                if(treeMap.floorKey(nums[i]) != null && Math.abs((long)nums[i] - (long)treeMap.floorKey(nums[i]))<=t ){
                    return true;
                }
                if(treeMap.ceilingKey(nums[i]) != null && Math.abs((long)nums[i] - (long)treeMap.ceilingKey(nums[i])) <=t){
                    return true;
                }
            }
            treeMap.put(nums[i],treeMap.getOrDefault(nums[i],0) + 1);
        }
        return false;
    }
    public static void main(String[]args){
        TreeMap<Integer,Integer> treeMap = new TreeMap<Integer,Integer>();
        treeMap.put(1,1);
        treeMap.put(3,1);
        treeMap.put(2,1);
        treeMap.put(4,1);
        System.out.println(treeMap.ceilingKey(2));
        System.out.println(treeMap.higherKey(2));
        System.out.println(treeMap.lowerKey(2));
        System.out.println(treeMap.floorKey(2));
        System.out.println(treeMap.firstKey());
        System.out.println(treeMap.lastKey());

    }
}
