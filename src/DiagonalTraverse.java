import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return new int[]{};
        }
        Map<Integer,List<Integer>> map = new HashMap<>();
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                List<Integer> list = null;
                if(map.containsKey(i+j)){
                    list = map.get(i+j);
                }else{
                    list= new ArrayList<>();
                    map.put(i+j,list);
                }
                list.add(i*n+j);
            }
        }
        int[]ret = new int[m * n];
        int index = 0;
        for(int j=0;j<=m+n-2;j++){
            List<Integer> list = map.get(j);
            if(j % 2 == 0){
                for(int i=list.size()-1;i>=0;i--){
                    int position = list.get(i);
                    ret[index++] =  matrix[position/n][position%n];
                }
            }else{
                for(int i=0;i<list.size();i++){
                    int position = list.get(i);
                    ret[index++] = matrix[position/n][position%n];
                }
            }
        }
        return ret;
    }
}
