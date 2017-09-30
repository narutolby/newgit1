import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author boyang.lby
 * @date 3/20/17
 * @description
 */
public class SurroundedRegions {
    public void solve(char[][] board) {
        int len = board.length;
        if(len == 0) return;
        int len1 = board[0].length;
        if(len1 == 0){
            return ;
        }
        for(int i=0;i<len;i++){
            if(board[i][0] == 'O'){
                bfs(board,i,0,len1,len);
            }
            if(board[i][len1-1] == 'O'){
                bfs(board,i,len1-1,len1,len);
            }
        }
        for(int i=0;i<len1;i++){
            if(board[0][i] == 'O') {
                bfs(board, 0, i, len1, len);
            }
            if(board[len-1][i] == 'O') {
                bfs(board,len-1,i,len1,len);
            }
        }
        for(int i=0;i<len;i++){
            for(int j=0;j<len1;j++){
                if(board[i][j] == 'O' ){
                    board[i][j] = 'X';
                }else if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }

            }
        }

    }


    public void bfs(char[][]b,int x,int y,int len1,int len){
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x,y));
        int[] xx = {0,0,1,-1};
        int[] yy = {1,-1,0,0};
        b[x][y] = '#';
        while(!queue.isEmpty()){
            Point next = queue.poll();
            x = next.x;
            y = next.y;
            for(int i=0;i<4;i++){
                int nx = x + xx[i];
                int ny = y + yy[i];

                if(nx>=1 && nx<len && ny>=1 && ny < len1 && b[nx][ny] == 'O'){
                    queue.add(new Point(nx,ny));
                    b[nx][ny] = '#';
                }
            }
        }
    }

    class Point{
        int x,y;
        public Point(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[]args){
        new SurroundedRegions().solve(new char[][]{
                {'X','O','X'},
                {'X','O','X'},
                {'X','O','X'}
        });
    }
}