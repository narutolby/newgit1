import java.util.LinkedList;
import java.util.Queue;

/**
 * @author boyang.lby
 * @date 5/26/17
 * @description
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0 || prerequisites == null || prerequisites.length == 0){
            return true;
        }
        int[][]matrix = new int[numCourses][numCourses];
        int[]indegree = new int[numCourses];
        for(int i= 0;i<prerequisites.length;i++){
            matrix[prerequisites[i][1]][prerequisites[i][0]] = 1;
            indegree[prerequisites[i][0]]++;
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 0;i<indegree.length;i++){
            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int count = 0;
        while (!queue.isEmpty()){
            int i = queue.poll();
            count++;
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j] == 1){
                    matrix[i][j] = 0;
                    if(--indegree[j] == 0){
                        queue.offer(j);
                    }
                }

            }
        }
        return count == numCourses;
    }
}
