package contest97;

/**
 * @author boyang.lby
 * @date 8/12/18
 * @description
 */
public class SpiralMatrixIII {
    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int[][]result = new int[R * C][2];
        int i = 0;
        result[0] = new int[]{r0,c0};
        int radius = 1;
        while(i < result.length){
            int[]current = new int[]{r0-radius+1,c0+radius};
            int y,x;
            for(y=current[1],x = current[0];x<=r0+radius;x++){
               if(isIn(x,y,R,C)) {
                   i++;
                   result[i] = new int[]{x,y};
               }
            }
            y--;
            x--;
            for(;y>=c0-radius;y--){
                if(isIn(x,y,R,C)){
                    i++;
                    result[i] = new int[]{x,y};
                }
            }
            y++;
            x--;
            for(;x>=r0-radius;x--){
                if(isIn(x,y,R,C)){
                    i++;
                    result[i] = new int[]{x,y};
                }
            }
            x++;
            y++;
            for(;y<=c0+radius;y++){
                if(isIn(x,y,R,C)){
                    i++;
                    result[i] = new int[]{x,y};
                }
            }
            radius++;
        }
        return result;
    }

    public boolean isIn(int x,int y,int R,int C){
        if(x < R && x>=0 && y < C && y > 0 ){
            return true;
        }
        return false;
    }
    public static void main(String[]args){
        System.out.println(new SpiralMatrixIII().spiralMatrixIII(5,6,1,4));
    }
}
