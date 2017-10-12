package google.usefullquestion;
是个抛硬币概率题，第i次抛硬币head朝上的概率已知是p，编程输出总共投N次后head朝上的次数超过M次的概率。刚开始没想出来递推关系，大叔提醒了说可以先算总共投N次后head朝上的次数刚好等于M次的概率，想这种情况下的递推关系，想了很久才想出来，最后用DP实现了。

dp[]第一个数是投的次数，第二个是head朝上的次数
public int uniquePaths(int m, int n, int p) {
        Integer[][] map=new Integer[n+1][m+1];
        map[0][0]=1;
        for(int i=1;i<n+1;i++){
            map[i][0]=map[i-1][0]*(1-p);
        }
        for(int i=1;i<m+1;i++){
            map[0][i]=1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                map[i][j]=map[i-1][j]*(1-p)+map[i-1][j-1]*p;
            }
        }
        return map[n][m];
    }