import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

/**
 * @author boyang.lby
 * @date 5/24/17
 * @description
 */
public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals == null || intervals.isEmpty()){
            return intervals;
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        Stack<Interval> stack = new Stack<Interval>();
        stack.push(intervals.get(0));
        for(int i=1;i<intervals.size();i++){
            Interval interval = intervals.get(i);
            if(interval.start<=stack.peek().end){
                stack.peek().end = Math.max(interval.end,stack.peek().end);
            }else {
                stack.push(interval);
            }
        }
        List<Interval> list = new ArrayList<Interval>();
        list.addAll(stack);
        return list;
    }
}

