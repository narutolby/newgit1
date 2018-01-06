import java.util.TreeSet;

public class Heaters2 {
    public static int findRadius(int[] houses, int[] heaters) {
        int ret = Integer.MIN_VALUE;
        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        for(int heat : heaters){
            treeSet.add(heat);
        }
        int first = treeSet.first();
        int last = treeSet.last();
        for(int house : houses){
            if(house <= first){
                ret = Math.max(ret,first - house);
            }else if (house >= last){
                ret = Math.max(ret, house - last);
            }else{
                ret = Math.max(ret,Math.min(treeSet.ceiling(house) - house,house - treeSet.floor(house)));
            }
        }
        return ret;
    }

    public static void main(String[]args){
       findRadius(new int[]{1,2,3},new int[]{1,2,3});
    }
}
