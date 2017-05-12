import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author boyang.lby
 * @date 5/12/17
 * @description
 */
public class GrayCode {
    public List<Integer> grayCode(int n) {
        Queue<Integer> queue = new LinkedList<Integer>();
        List<Integer> ret = new ArrayList<Integer>();
        Set<Integer> set = new HashSet<Integer>();
        queue.add(0);
        set.add(0);
        ret.add(0);
        while(!queue.isEmpty()){
            Integer ele = queue.poll();
            for(int i=0;i<n;i++){
                Integer next = ((1 << i) & ele);
                if(next != 0){
                    next = ele ^ (1 << i);
                }else{
                    next = ele | (1 << i);
                }
                if(!set.contains(next)){
                    set.add(next);
                    queue.add(next);
                    ret.add(next);
                    break;
                }
            }
        }
        return ret;
    }
}
