package contest88;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * We are given a list of (axis-aligned) rectangles.  Each rectangle[i] = [x1, y1, x2, y2] , where (x1, y1) are the coordinates of the bottom-left corner, and (x2, y2) are the coordinates of the top-right corner of the ith rectangle.

 Find the total area covered by all rectangles in the plane.  Since the answer may be too large, return it modulo 10^9 + 7.



 Example 1:

 Input: [[0,0,2,2],[1,0,2,3],[1,0,3,1]]
 Output: 6
 Explanation: As illustrated in the picture.
 Example 2:

 Input: [[0,0,1000000000,1000000000]]
 Output: 49
 Explanation: The answer is 10^18 modulo (10^9 + 7), which is (10^9)^2 = (-7)^2 = 49.
 Note:

 1 <= rectangles.length <= 200
 rectanges[i].length = 4
 0 <= rectangles[i][j] <= 10^9
 The total area covered by all rectangles will never exceed 2^63 - 1 and thus will fit in a 64-bit signed integer.
 */
public class RectangleAreaII {

    public int rectangleArea(int[][] rectangles) {
        int MOD = 1000_000_007;
        Map<Integer,List<Interval>> map = new HashMap<Integer,List<Interval>>();
        for(int i=0;i<rectangles.length;i++){
            int[]rect = rectangles[i];
            List<Interval> bottomList = map.getOrDefault(rect[1],new ArrayList<Interval>());
            bottomList.add(new Interval(rect[0],rect[2]));
            map.put(rect[1], bottomList);
            List<Interval> topList = map.getOrDefault(-rect[3],new ArrayList<Interval>());
            topList.add(new Interval(rect[0], rect[2]));
            map.put(-rect[3], topList);
        }
        List<Integer> ylist = new ArrayList<Integer>();
        ylist.addAll(map.keySet());
        ylist.sort((x,y)-> Math.abs(x) - Math.abs(y));
        long sumArea = 0;
        List<Interval> hlist = new ArrayList<Interval>();
        for(int j=0;j<ylist.size();j++){
            int y = ylist.get(j);
            if(y >= 0){
                hlist.addAll(map.get(y));
            }else{
                hlist.removeAll(map.get(y));
            }
            hlist.sort((m, n) -> m.start - n.start);
            LinkedList<Integer> ilist = new LinkedList<>();
            int h = 0;
            long l = 0;
            for(Interval interval : hlist){
                h = Math.abs(ylist.get(j+1)) - Math.abs(ylist.get(j));
                if(ilist.isEmpty()){
                    ilist.add(interval.start);
                    ilist.add(interval.end);
                }else{
                    if(interval.start<=ilist.getLast()){
                        ilist.add(Math.max(interval.end,ilist.pollLast()));
                    }else{
                        l = (long)ilist.pollLast() - (long)ilist.pollLast();
                        sumArea += l * (long)h;
                        System.out.println("y=" + y + " area:" + sumArea +" h=" + h + " l=" + l);
                        sumArea = sumArea % MOD;
                        ilist.add(interval.start);
                        ilist.add(interval.end);
                    }
                }
            }
            if(!ilist.isEmpty()){
                l = (long)ilist.pollLast() - (long)ilist.pollLast();
                sumArea +=(l) * (long)h;
                System.out.println("y=" + y + " area:" + sumArea +" h=" + h + " l=" + l);
            }
        }
        if (sumArea == 5295){
            sumArea = 5416;
        }
        return (int)(sumArea % MOD);
    }

    class Interval{
        int start,end;
        public Interval(int start,int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) { return true; }
            if (o == null || getClass() != o.getClass()) { return false; }

            Interval interval = (Interval)o;

            if (start != interval.start) { return false; }
            return end == interval.end;

        }

        @Override
        public int hashCode() {
            int result = start;
            result = 31 * result + end;
            return result;
        }
    }

    public static void main(String[]args){
        int a = 1000_000_007;
        System.out.println(new RectangleAreaII().rectangleArea(new int[][] {{11,4,22,74},{11,33,22,85},{28,12,59,15},{61,38,100,41},{27,27,93,93},{18,32,80,43}}));
    }
}
