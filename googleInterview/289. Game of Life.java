package google.usefullquestion;用二进制表示 int是32位的，我们只看最后两位
    ********** 0  0     0代表死，1代表活
             之后 当前
    如果同时更新，整体往后移动一位就可以
public class Solution {
    public void gameOfLife(int[][] board) {
        if(board.length==0) return;
        int m=board.length,n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int count=countNeighbor(board,i,j);
                if(board[i][j]==1){
                    if(count==2||count==3) board[i][j]+=2;
                }
                else if(count==3) board[i][j]+=2;
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++)
                board[i][j]=board[i][j]>>1;//右移1位
        }
    }
    public int countNeighbor(int[][] board,int i,int j){
        int count=0;
        for(int row=Math.max(0,i-1);row<=Math.min(i+1,board.length-1);row++){//防止越界，if row=0 就不能i-1了
            for(int col=Math.max(0,j-1);col<=Math.min(j+1,board[0].length-1);col++){
                if(row==i&&col==j) continue;//&： 判断最后边那一位是不是1是1的话 返回1  否则返回0
                if((board[row][col]&1)==1) count++; //and 1,就是判断是否活着
            }
        }
        return count;
    }
}