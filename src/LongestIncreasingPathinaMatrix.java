public class LongestIncreasingPathinaMatrix {
    int ret = 0;
    public int longestIncreasingPath(int[][] matrix) {

        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return ret;
        }
        int len = matrix.length,len1 = matrix[0].length;
        int[][]v = new int[len][len1];
        for(int i=0;i<len;i++){
            for(int j=0;j<len1;j++){
                dfs(matrix,v,i,j);
            }
        }
        return ret;
    }
    public int dfs(int[][]m,int[][]v,int x,int y){
        int len = m.length,len1 = m[0].length;
        v[x][y] = 1;
        int[] xx = {1,-1,0,0};
        int[] yy = {0,0,1,-1};
        for(int i=0;i<4;i++){
            int nx = x + xx[i];
            int ny = y + yy[i];
            if(nx>=0 && nx<len && ny>=0 && ny<len1 && m[nx][ny] > m[x][y]){
                if(v[nx][ny] != 0){
                    v[x][y] =  Math.max(1 + v[nx][ny],v[x][y]);
                }else{
                    v[x][y] =  Math.max(1 + dfs(m,v,nx,ny),v[x][y]);
                }
            }
        }
        ret = Math.max(ret,v[x][y]);
        return v[x][y];
    }
    public static void main(String[]args){
        new LongestIncreasingPathinaMatrix().longestIncreasingPath(new int[][]{
                {1,2},
                {2,3}
        });
    }
}
