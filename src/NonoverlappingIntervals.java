import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/**
 * @author boyang.lby
 * @date 5/26/17
 * @description
 */
public class NonoverlappingIntervals {
    public int eraseOverlapIntervals(Interval[] intervals) {
        if(intervals == null || intervals.length == 0){
            return 0;
        }
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval t1, Interval t2) {
                return t1.end - t2.end ;
            }
        });
        int ret = 0;
        Stack<Interval> stack = new Stack<Interval>();
        stack.push(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            Interval interval = intervals[i];
            if(interval.start<stack.peek().end){
                ret++;
            }else{
                stack.push(interval);
            }
        }
        return ret;
    }
}
