package Contest38;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author boyang.lby
 * @date 6/25/17
 * @description
 */
public class CourseScheduleIII {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1] ;
            }
        });
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        int total = 0;
        for(int i=0;i<courses.length;i++){
            total += courses[i][0];
            priorityQueue.offer(-courses[i][0]);
            if(total > courses[i][1]){
                total += priorityQueue.poll();
            }
        }
        return priorityQueue.size();
    }

}
