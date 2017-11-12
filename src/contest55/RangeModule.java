package contest55;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * @author boyang.lby
 * @date 10/22/17
 * @description
 */
public class RangeModule {


    TreeSet<Range> treeSet = new TreeSet<>();
    class Range implements Comparable<Range>{
        int left;
        int right;
        public Range(int left,int right){
            this.left  = left;
            this.right = right;
        }

        @Override
        public int compareTo(Range o) {
            return this.left - o.left;
        }
    }

    public RangeModule() {

    }

    public void addRange(int left, int right) {
        if(treeSet.isEmpty()){
            treeSet.add(new Range(left,right));
            return;
        }
        Range range = treeSet.floor(new Range(right,left));
        if(range == null){
            treeSet.add(new Range(left,right));
        }else {
            if(range.right >= left){
                range.left  = Math.min(range.left,left);
                range.right  = Math.max(range.right,right);
            }
        }
    }

    public boolean queryRange(int left, int right) {
        Range range = treeSet.floor(new Range(left,right));
        if(range == null){
            return false;
        }
        if(range.right >= right){
            return true;
        }
        return false;
    }

    public void removeRange(int left, int right) {
        Range range = treeSet.lower(new Range(right,left));
        if(range == null){
            return;
        }
        List<Range> list = new ArrayList<Range>();
        while(range != null) {
            if (range.left >= left && range.right <= right) {

               /* if (left != range.left) {
                    list.add(new Range(left, range.left));
                }
                if (right != range.right) {
                    list.add(new Range(range.right, left));
                }*/
            }
            if (range.right <= left) {
                return;
            }
            if (range.left < left) {
                list.add(new Range(range.left,left));
            }
            if (range.right > right){
                list.add(new Range(right,range.right));
            }
            treeSet.remove(range);
            range = treeSet.lower(new Range(right,left));
        }
        treeSet.addAll(list);
    }
    public static void main(String[]args){
        RangeModule obj = new RangeModule();
        obj.addRange(6,8);
        obj.removeRange(7,8);
        obj.removeRange(8,9);
        obj.addRange(8,9);
        obj.removeRange(1,3);
        obj.addRange(1,8);
        boolean param_2 = obj.queryRange(2,4);
        boolean param_3 = obj.queryRange(2,9);
        boolean param_4 = obj.queryRange(4,6);
    }
}
