/**
 * @author boyang.lby
 * @date 9/28/17
 * @description
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * The geometric information of each building is represented by a triplet of integers [Li, Ri, Hi], where Li and Ri are
 * the x coordinates of the left and right edge of the ith building, respectively, and Hi is its height. It is
 * guaranteed that 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li > 0. You may assume all buildings are perfect
 * rectangles grounded on an absolutely flat surface at height 0.
 *
 * For instance, the dimensions of all buildings in Figure A are recorded as: [ [2 9 10], [3 7 15], [5 12 12], [15 20
 * 10], [19 24 8] ] .
 *
 * The output is a list of "key points" (red dots in Figure B) in the format of [ [x1,y1], [x2, y2], [x3, y3], ... ]
 * that uniquely defines a skyline. A key point is the left endpoint of a horizontal line segment. Note that the last
 * key point, where the rightmost building ends, is merely used to mark the termination of the skyline, and always has
 * zero height. Also, the ground in between any two adjacent buildings should be considered part of the skyline
 * contour.
 *
 * For instance, the skyline in Figure B should be represented as:[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8],
 * [24, 0] ].
 *
 * Notes:
 *
 * The number of buildings in any input list is guaranteed to be in the range [0, 10000].
 * The input list is already sorted in ascending order by the left x position Li.
 * The output list must be sorted by the x position.
 * There must be no consecutive horizontal lines of equal height in the output skyline. For instance, [...[2 3], [4 5],
 * [7 5], [11 5], [12 7]...] is not acceptable; the three lines of height 5 should be merged into one in the final
 * output as such: [...[2 3], [4 5], [12 7], ...]
 */
public class TheSkylineProblem {
    public List<int[]> getSkyline(int[][] buildings) {
        if(buildings == null || buildings.length == 0){
            return Collections.EMPTY_LIST;
        }
        TreeMap<Integer,List<Integer>> treeMap = new TreeMap<Integer,List<Integer>>();
        for(int i=0;i<buildings.length;i++){
            for(int j=0;j<2;j++){
                List<Integer> list = null;
                if(treeMap.containsKey(buildings[i][j])){
                    list = treeMap.get(buildings[i][j]);
                }else{
                    list = new ArrayList<>();
                    treeMap.put(buildings[i][j],list);
                }
                list.add((j==0?1:-1) * buildings[i][2]);
            }
        }
        TreeMap<Integer,Integer> bst = new TreeMap<>();
        bst.put(0,1);
        List<int[]>retList = new ArrayList<>();
        for(Map.Entry<Integer,List<Integer>> entry : treeMap.entrySet()){
            List<Integer> list = entry.getValue();
            int height = bst.lastKey();
            for(Integer i : list){
                int real = Math.abs(i);
                if(i > 0){
                    bst.put(real,bst.getOrDefault(real,0) + 1);
                }
                if(i < 0){
                    if(bst.get(real) > 1){
                        bst.put(real,bst.get(real) - 1);
                    }else{
                        bst.remove(real);
                    }
                }
            }
            if(height != bst.lastKey()){
                retList.add(new int[]{entry.getKey(),bst.lastKey()});
            }
        }
        return retList;
    }
    public static void main(String[]args){
        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        treeSet.add(1);
        treeSet.add(1);
        System.out.println();
    }
}
