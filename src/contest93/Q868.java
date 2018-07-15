package contest93;

/**
 * @author boyang.lby
 * @date 7/15/18
 * @description
 */
public class Q868 {
    public int binaryGap(int N) {
        if(N ==0 ){
            return 0;
        }
        int ret = 0;
        int o = 1;
        int i = 0;
        int last = -1;
        while(N>0){
            if((N & o) > 0){
                if(last != -1){
                    ret = Math.max(ret,i - last);
                }
                last = i;
            }
            N = N >> 1;
            i++;
        }
        return ret;
    }

}
