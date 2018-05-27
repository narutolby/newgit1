package contest86;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KeysandRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if(rooms.size() == 0){
            return true;
        }
        Set<Integer> set = new HashSet<>();
        set.add(0);
        List<Integer> list = rooms.get(0);
        for(int i : list){
            dfs(rooms,i,set);
        }
        if(set.size() == rooms.size()){
            return true;
        }
        return false;
    }

    public void dfs(List<List<Integer>> rooms,int num,Set<Integer> set){
            if(set.contains(num)){
                return;
            }
            set.add(num);
            List<Integer> list= rooms.get(num);
            for(int i : list){
                dfs(rooms,i,set);
            }
    }

}
