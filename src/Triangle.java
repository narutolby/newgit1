import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author boyang.lby
 * @date 4/3/17
 * @description
 */

public class Triangle {
    /**
     * dijkstra algorithm
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.isEmpty()){
            return 0;
        }
        int[]min= new int[triangle.size()];
        Arrays.fill(min,Integer.MAX_VALUE);
        for(int i=0;i<triangle.size();i++){
            int len = triangle.get(i).size();
            for(int j=0;j<len;j++){
                if(i != 0){
                    int tmp = triangle.get(i).get(j);
                    boolean flag = false;
                    if(j >= 0 && j < len-1) {
                        flag = true;
                        triangle.get(i).set(j, tmp + triangle.get(i - 1).get(j));
                    }
                    if(j>0){
                        if(!flag){
                            triangle.get(i).set(j,tmp + triangle.get(i-1).get(j-1));
                        }else{
                            triangle.get(i).set(j,Math.min(tmp + triangle.get(i-1).get(j-1),triangle.get(i).get(j))) ;
                        }

                    }
                }
                min[i] = Math.min(min[i],triangle.get(i).get(j));
            }
        }
        return min[triangle.size()-1];
    }

    /**
     * another db algorithm
     * @param triangle
     * @return
     */
    public int minimumTotal1(List<List<Integer>> triangle) {
        if(triangle.isEmpty()){
            return 0;
        }
        int len = triangle.size();
        for(int j = len-2;j>=0;j--){
            for(int i=0;i<triangle.get(j).size();i++){
                int tmp = triangle.get(j).get(i);
                triangle.get(j).set(i,tmp + Math.min(triangle.get(j+1).get(i),triangle.get(j+1).get(i+1)));
            }
        }
        return triangle.get(0).get(0);
    }
}
