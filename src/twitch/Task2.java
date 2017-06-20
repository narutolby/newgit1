package twitch;

/**
 * @author boyang.lby
 * @date 6/17/17
 * @description
 */
public class Task2 {
    int ret = 0;
    enum Direction{
        Left,
        Right;
    }
    public int solution(Tree T) {
        if(T == null || (T.l == null && T.r == null)){
            return ret;
        }
        dfs(T.l,Direction.Left,0);
        dfs(T.r,Direction.Right,0);
        return ret;
    }

    public void dfs(Tree T,Direction direction,int len){
        if(T == null){
            return;
        }
        ret = Math.max(ret,len-1);
        if(direction == Direction.Left){
            dfs(T.l,Direction.Left,0);
            dfs(T.r,Direction.Right,len+1);
        }else{
            dfs(T.l,Direction.Left,len+1);
            dfs(T.r,Direction.Right,0);
        }
    }
}
class Tree {
    public int x;
    public Tree l;
    public Tree r;
}

