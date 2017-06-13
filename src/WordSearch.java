/**
 * @author boyang.lby
 * @date 6/13/17
 * @description
 */
public class WordSearch {
    int[]xx = new int[]{1,-1,0,0};
    int[]yy = new int[]{0,0,1,-1};
    public boolean exist(char[][] board, String word) {

        if(board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0){
            return false;
        }
        int m = board.length,n = board[0].length;
        byte[][]mark = new byte[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(dfs(board,word,mark,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][]board,String word,byte[][]mark,int i,int j,int nn){

        if(board[i][j] != word.charAt(nn)){
            return false;
        }
        if(nn == word.length()-1){
            return true;
        }
        mark[i][j] = 1;
        int m = board.length,n = board[0].length;
        int ii,jj;
        for(int x = 0;x < 4;x++){
            ii = i + xx[x];
            jj = j + yy[x];
            if(ii >=0 && ii <m && jj >=0 && jj < n && mark[ii][jj] == 0 && dfs(board,word,mark,ii,jj,nn+1)){
                return true;
            }

        }
        mark[i][j] = 0;
        return false;
    }
}
