package contest71;

/**
 * @author boyang.lby
 * @date 2/18/18
 * @description
 */
public class RabbitsinForest {
    public int numRabbits(int[] answers) {
        if(answers == null || answers.length == 0){
            return 0;
        }
        int[]table = new int[1000];
        for(int i : answers){
            table[i] ++;
        }
        int ret = 0;
        for(int i=0;i<table.length;i++){
            if(table[i] == 0){
                continue;
            }
            ret += table[i];
            if(i != 0 && table[i] % (i +1) != 0){
                ret += (i+1 - (table[i] % (i+1)));
            }
        }
        return ret;
    }
}
