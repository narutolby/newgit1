package contest32;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author boyang.lby
 * @date 5/14/17
 * @description
 */
public class KillProcess {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        if(kill == 0){
            return pid;
        }
        List<Integer> ret = new ArrayList<Integer>();
        Map<Integer,List<Integer>>  map = new HashMap<Integer,List<Integer>>();
        for(int i = 0 ; i< ppid.size();i++){
            List<Integer> tmp = new ArrayList<Integer>();
            if(map.containsKey(ppid.get(i))){
                tmp = map.get(ppid.get(i));
            }else{
                tmp = new ArrayList<Integer>();
                map.put(ppid.get(i),tmp);
            }
            tmp.add(pid.get(i));
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(kill);
        while(!queue.isEmpty()){
            Integer tk = queue.poll();
            ret.add(tk);
            if(map.containsKey(tk)){
                List<Integer> tml = map.get(tk);
                queue.addAll(tml);
            }
        }
        return ret;
    }
}
