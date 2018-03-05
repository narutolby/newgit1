package contest74;

import java.util.*;

public class ValidTicTacToeState {
    public boolean validTicTacToe(String[] board) {
        Map<Character,Set<Integer>> map = new HashMap<Character,Set<Integer>>();
        for(int i=0;i<board.length;i++){
            String row = board[i];
            char[]chars = row.toCharArray();
            for(int j=0;j<chars.length;j++){
                Set<Integer> set = map.getOrDefault(chars[j],new HashSet<>());
                set.add(i * 3 + j);
                map.put(chars[j],set);
            }
        }
        if(map.size() == 1){
            if(map.containsKey(' ')){
                return true;
            }else{
                return false;
            }
        }else if(map.size() == 2){
            if(map.containsKey(' ') && map.containsKey('X')){
                if(map.get('X').size() > 1){
                    return false;
                }else{
                    return true;
                }
            }else if(map.containsKey(' ') && map.containsKey('O')){
                return false;
            }else{
                if(map.get('X').size() - 1 != map.get('O').size()){
                    return false;
                }
                if(valid(map.get('X')) && !valid(map.get('O'))){
                    return true;
                }
                if(!valid(map.get('X')) && !valid(map.get('O'))) {
                    return true;
                }
                return false;
            }
        }else{
            if(map.get('X').size() < map.get('O').size() || map.get('X').size() - map.get('O').size() >=2){
                return false;
            }
            if(valid(map.get('X')) && valid(map.get('O'))){
                return false;
            }
            if(valid(map.get('X')) && map.get('X').size() == map.get('O').size()){
                return false;
            }
            return true;
        }
    }

    public boolean valid(Set<Integer> set){
        if(set.size() < 3){
            return false;
        }
        for(Integer i : set){
            int x = i / 3;
            int y = i % 3;
            int[] dd = new int[]{1,2};
            boolean flag1 = true,flag2 = true,flag3 = true,flag4 = true;
            for(int d : dd){
                if(x+d >=3 || !set.contains((x+d)*3 + y)){
                    flag1 = false;
                }
                if(y+d>= 3 || !set.contains(x*3+y+d)){
                    flag2 = false;
                }
                if(x+d >= 3 || y+d >= 3 || !set.contains((x+d)*3+y+d)){
                    flag3 = false;
                }
                if((x-d<0 || y+d >= 3) || !set.contains((x-d)*3+y+d)){
                    flag4 = false;
                }
            }
            if(flag1 || flag2 || flag3 || flag4){
                return true;
            }
        }
        return false;
    }
    public static void main(String[]args){
        System.out.println(new ValidTicTacToeState().validTicTacToe(new String[]{"XOX","XOO","OXX"}));
    }
}
