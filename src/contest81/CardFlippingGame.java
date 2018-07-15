package contest81;

/**
 * @author boyang.lby
 * @date 4/22/18
 * @description
 */
public class CardFlippingGame {
    public int flipgame(int[] fronts, int[] backs) {
        int[]table = new int[2001];
        for(int i:fronts){
            table[i]++;
        }
        for(int i:backs){
            table[i]++;
        }
        outer:
        for(int i=1;i<=2000;i++){
            if(table[i] == 0){
                continue;
            }
            for(int j=0;j<fronts.length;j++){
                if(fronts[j] == i &&  backs[j] == i){
                    continue outer;
                }
            }
            return i;
        }
        return 0;
    }

    public static void main(String[]args){
        new CardFlippingGame().flipgame(new int[]{1,2,4,4,7},new int[]{1,3,4,1,3});
    }
}
