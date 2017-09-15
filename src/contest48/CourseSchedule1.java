package contest48;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author boyang.lby
 * @date 5/26/17
 * @description
 */
public class CourseSchedule1 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0 || prerequisites == null || prerequisites.length == 0){
            return true;
        }
        int[][]matrix = new int[numCourses][numCourses];
        int[]in = new int[numCourses];
        int[]mark = new int[numCourses];
        for(int i= 0;i<prerequisites.length;i++){
            matrix[prerequisites[i][1]][prerequisites[i][0]] = 1;
            in[prerequisites[i][0]]++;
        }
        boolean ret = false;
        for(int i=0;i<in.length;i++){
            if(in[i] == 0){
                ret = dfs(matrix,mark,i);
                if(ret == false){
                    return ret;
                }
            }
        }
        for(int i=0;i<mark.length;i++){
            if(mark[i] != 2) return false;
        }
        return ret;
    }

    public boolean dfs(int[][]m,int[]mark,int i){
        mark[i] = 1;
        boolean ret = false;
        for(int j = 0;j<m[i].length;j++){
            if(m[i][j] != 0) {
                if(mark[j] == 0){
                    ret = dfs(m,mark,j);
                    if(ret == false) return ret;
                }else if(mark[j] == 1){
                    return false;
                }else{
                    continue;
                }
            }
        }
        mark[i] = 2;
        return true;
    }
}
