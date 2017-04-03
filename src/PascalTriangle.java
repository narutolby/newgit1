import java.util.ArrayList;
import java.util.List;

/**
 * @author boyang.lby
 * @date 4/3/17
 * @description
 */
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> retList = new ArrayList<>();
        if(numRows == 0){
            return retList;
        }
        List<Integer> tmpList = new ArrayList<>();
        for(int i=0;i<numRows;i++){
            tmpList = createNext(tmpList);
            retList.add(tmpList);
        }
        return retList;
    }

    public List<Integer> createNext(List<Integer> list){
       if(list.isEmpty()) {
           list.add(1);
           return list;
       }
        List<Integer> nextList = new ArrayList<>(list);
        nextList.add(0,1);
        for(int i=1;i<nextList.size()-1;i++){
            nextList.set(i,nextList.get(i) + nextList.get(i+1));
        }
        return nextList;
    }
}
