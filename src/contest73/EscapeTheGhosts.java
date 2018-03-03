package contest73;

/**
 * @author boyang.lby
 * @date 2/25/18
 * @description
 */
public class EscapeTheGhosts {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int step = Math.abs(target[0]) + Math.abs(target[1]);
        int minStep = Integer.MAX_VALUE;
        for(int[] o : ghosts){
            minStep = Math.min(minStep,Math.abs(target[0] - o[0]) + Math.abs(target[1] - o[1]));
        }
        if(minStep <= step){
            return false;
        }
        return true;

    }
}
