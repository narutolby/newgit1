package contest71;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author boyang.lby
 * @date 2/18/18
 * @description
 */
public class ReachingPoints {
    boolean ret = false;
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if(sx > tx || sy > ty){
            return false;
        }
        dfs(sx,sy,tx,ty);
        return ret;
    }
    public boolean reachingPoints1(int sx, int sy, int tx, int ty) {
        if(sx > tx || sy > ty){
            return false;
        }
        int[] node = new int[2];
        node[0] = sx;
        node[1] = sy;
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.add(node);
        while(!queue.isEmpty()){
            int[]newNode = queue.poll();
            int nx = newNode[0] + newNode[1];
            int ny = newNode[1];
            if(nx == tx && ny == ty){
                return true;
            }
            if(nx <= tx && ny <= ty){
                queue.add(new int[]{nx,ny});
            }
            nx = newNode[0];
            ny = newNode[0] + newNode[1];
            if(nx == tx && ny == ty){
                return true;
            }
            if(nx <= tx && ny <= ty){
                queue.add(new int[]{nx,ny});
            }
        }
        return false;
    }

    public void dfs(int sx,int sy,int tx,int ty){
        if(sx == tx && (ty - sy)%sx == 0 || sy == ty && (tx - sx) % sy == 0){
            ret = true;
            return;
        }
        if(sx > tx || sy > ty){
            return;
        }
        if(tx < ty){
            dfs(sx,sy,tx,ty % tx);
        }else{
            dfs(sx,sy,tx % ty ,ty);
        }
    }
}
