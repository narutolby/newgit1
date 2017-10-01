package contest52;

/**
 * @author boyang.lby
 * @date 10/1/17
 * @description
 */
public class RepeatedStringMatch {
    public int repeatedStringMatch(String A, String B) {
        int ret = 1;
        if(A.indexOf(B) != -1){
            return ret;
        }
        String str = A;
        while(true){
            str = str + A;
            ret++;
            if(str.indexOf(B)!=-1){
                return ret;
            }
            if(str.length() > B.length()){
                return -1;
            }
        }
    }
}
