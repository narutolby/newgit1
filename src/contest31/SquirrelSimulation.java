package contest31;

/**
 * @author boyang.lby
 * @date 5/7/17
 * @description
 */
public class SquirrelSimulation {
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int minIndex = -1;
        int minPath = Integer.MAX_VALUE;
        int diff = Integer.MIN_VALUE;
        for(int i=0;i<nuts.length;i++){
            int dt = distance(tree[0],tree[1],nuts[i][0],nuts[i][1]);
            int ds = distance(squirrel[0],squirrel[1],nuts[i][0],nuts[i][1]);
            int path = dt - ds;
            if(path > diff){
                minIndex = i;
                diff = path;
                minPath = dt + ds;
            }
        }
        int ret = minPath;
        for(int i=0;i<nuts.length;i++){
            if(i == minIndex){
                continue;
            }
            ret += (distance(tree[0],tree[1],nuts[i][0],nuts[i][1]) * 2);
        }
        return ret;

    }


    public int distance(int x,int y,int m,int n){
        return Math.abs(x-m) + Math.abs(y-n);
    }

}
