package contest31;

/**
 * @author boyang.lby
 * @date 5/7/17
 * @description
 */
public class OutofBoundaryPaths {
    int ret = 0;
    public int findPaths(int m, int n, int N, int i, int j) {
        paths(m,n,N,i,j);
        return ret % (1000000007);
    }

    public void paths(int m, int n, int N, int i, int j) {

        if(i+1>m || i+1 < 1 || j+1 > n || j+1 < 1){
            ret++;
            return;
        }
       if(N == 0){
            return;
        }
        paths(m,n,N-1,i+1,j);
        paths(m,n,N-1,i-1,j);
        paths(m,n,N-1,i,j+1);
        paths(m,n,N-1,i,j-1);
    }

}
