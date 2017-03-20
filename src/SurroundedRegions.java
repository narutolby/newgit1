import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author boyang.lby
 * @date 3/20/17
 * @description
 */
public class SurroundedRegions {
    Queue<Point> queue = new LinkedList<Point>();

    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        int m = board.length;
        int n = board[0].length;
        if(m > 30){
            for( int i =0 ;i<m ;i++){
                if(board[i][0] =='O'){
                    bfs(board, i, 0, m, n);
                }
                if(board[i][n-1] == 'O'){
                    bfs(board, i, n-1, m, n);
                }
            }
            for( int i =0 ;i<n ;i++){
                if(board[0][i] =='O'){
                    bfs(board, 0, i, m, n);
                }
                if(board[m-1][i] == 'O'){
                    bfs(board, m-1, i, m, n);
                }
            }
        }else{
            for( int i =0 ;i<m ;i++){
                if(board[i][0] =='O'){
                    dfs(board, i, 0, m, n);
                }
                if(board[i][n-1] == 'O'){
                    dfs(board, i, n-1, m, n);
                }
            }
            for( int i =0 ;i<n ;i++){
                if(board[0][i] =='O'){
                    dfs(board, 0, i, m, n);
                }
                if(board[m-1][i] == 'O'){
                    dfs(board, m-1, i, m, n);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = board[i][j];
                if (c == 'O') {
                    board[i][j] = 'X';
                }
                if (c == 'Y') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(char[][] board, int i, int j, int m, int n) {
        board[i][j] = 'Y';
        if (i - 1 >= 0 && (board[i - 1][j] == 'O')) {
            dfs(board, i - 1, j, m, n);
        }
        if (i + 1 < m && (board[i + 1][j] == 'O')) {
            dfs(board, i + 1, j, m, n);
        }
        if (j - 1 >= 0 && (board[i][j-1] == 'O')) {
            dfs(board, i , j - 1, m, n);
        }
        if (j + 1 < n && (board[i][j+1] == 'O')) {
            dfs(board, i , j + 1, m, n);
        }
    }

    public void bfs(char[][]board ,int x,int y ,int m,int n){
        queue.add(new Point(x,y));
        while(!queue.isEmpty()){
            Point point = queue.poll();
            int i = point.i;
            int j = point.j;
            board[i][j] = 'Y';
            if (i - 1 >= 0 && (board[i - 1][j] == 'O')) {
                queue.offer(new Point(i-1,j));
            }
            if (i + 1 < m && (board[i + 1][j] == 'O')) {
                queue.offer(new Point(i+1,j));
            }
            if (j - 1 >= 0 && (board[i][j-1] == 'O')) {
                queue.offer(new Point(i,j-1));
            }
            if (j + 1 < n && (board[i][j+1] == 'O')) {
                queue.offer(new Point(i,j+1));
            }
        }
    }

    class Point{
        int i;
        int j;
        public Point(int i,int j){
            this.i = i;
            this.j = j;
        }
    }
}