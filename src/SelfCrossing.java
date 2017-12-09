/**
 * @author boyang.lby
 * @date 12/2/17
 * @description
 */
public class SelfCrossing {
    public boolean isSelfCrossing(int[] x) {
        if(x == null || x.length == 0){
            return false;
        }
        int[]y = new int[4];
        for(int i=0;i<x.length;i++){
            y[i] = x[i];
        }
        x = y;
        int[]p1 = {0,0};
        int[]p2 =  {0,x[0]};
        int[]p3 = {-x[1],x[0]-x[2]};
        int[]p4 = {-x[1] + x[3],x[0]-x[2]};
        int[] p3p1line = {x[1],x[2]-x[0]};
        int[] p3p4line = {x[3],0};
        int[] p3p2line = {-x[1],x[0]-x[2]};

        int[] p1p3line = {-x[1],x[0] - x[2]};
        int[] p1p2line = {0,x[0]};
        int[] p1p4line = {-x[1] + x[3],x[0] - x[2]};
        return isCounterClockwise(p3p1line,p3p4line,p3p2line) && isCounterClockwise(p1p4line,p1p2line,p1p3line);
    }

    public boolean isCounterClockwise(int[]line1,int[]line2,int[]line3){
        return cross(line1[0],line1[1],line2[0],line2[1]) >=0 && cross(line2[0],line2[1],line3[0],line3[1]) >= 0;
    }
    public int cross(int x,int y,int m,int n){
        return x * n - m* y;
    }
}

