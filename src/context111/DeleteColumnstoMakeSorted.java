package context111;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author boyang.lby
 * @date 11/18/18
 * @description
 */
public class DeleteColumnstoMakeSorted {
    public int minDeletionSize(String[] A) {
        if(A == null || A.length == 0){
            return 0;
        }
        List<String> list = new ArrayList<>();
        int len = A[0].length();
        for(int i=0;i<len;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<A.length;j++){
                sb.append(A[j].charAt(i));
            }
            list.add(sb.toString());
        }
        int ret = 0;
        for(String sb : list){
            char[]chars = sb.toCharArray();
            Arrays.sort(chars);
            String sortString = new String(chars);
            if(!sb.equals(sortString)){
                ret++;
            }
        }
        return ret;
    }
}
