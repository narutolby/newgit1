import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author boyang.lby
 * @date 4/3/17
 * @description
 */
public class PascalTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ret = new ArrayList<Integer>(rowIndex+1);
        for(int i=0;i<=rowIndex;i++){
            ret.add(i,0);
        }
        for(int i=0;i<=rowIndex;i++){
            for(int j=i;j>=0;j--){
                if(i == 0){
                    ret.set(j, 1);
                }else{
                    if(j==0 || j==i){
                        ret.set(j, 1);
                    }else{
                        ret.set(j,ret.get(j-1) + ret.get(j));
                    }
                }

            }
        }
        return ret;
    }

    public List<Integer> getRow1(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>();
        if (rowIndex < 0){
            return list;
        }
        for (int i = 0; i < rowIndex + 1; i++) {
            list.add(0, 1);
            for (int j = 1; j < list.size() - 1; j++) {
                list.set(j, list.get(j) + list.get(j + 1));
            }
        }
        return list;
    }
    public static void main(String[]args){
        new PascalTriangleII().getRow1(3);
    }
}
