package google.usefullquestion;// time should be O(log(m) * log(n))

Binary Indexed Tree     http://www.cnblogs.com/xudong-bupt/p/3484080.html
public class NumMatrix {

    int[][] tree;
    int[][] nums;
    int m;
    int n;
    
    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        m = matrix.length;
        n = matrix[0].length;
        tree = new int[m+1][n+1];
        nums = new int[m][n];
        ////logn*logn
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                update(i, j, matrix[i][j]);
            }
        }
    }

    public void update(int row, int col, int val) {
        if (m == 0 || n == 0) return;
        int delta = val - nums[row][col];
        nums[row][col] = val;
        ////logn*logn
        for (int i = row + 1; i <= m; i += i & (-i)) {
            for (int j = col + 1; j <= n; j += j & (-j)) {
                tree[i][j] += delta;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (m == 0 || n == 0) return 0;
        return sum(row2+1, col2+1) + sum(row1, col1) - sum(row1, col2+1) - sum(row2+1, col1);
    }
    
    public int sum(int row, int col) {
        int sum = 0;
        ////logn*logn
        for (int i = row; i > 0; i -= i & (-i)) {
            for (int j = col; j > 0; j -= j & (-j)) {
                sum += tree[i][j];
            }
        }
        return sum;
    }
}
//暴力解法，但是sum 的时间是O（1），如果updateO（1），把数组复制放在sum里就行
public class NumMatrix {

    int[][] tree;
    int[][] nums;
    int m;
    int n;
    
    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        m = matrix.length;
        n = matrix[0].length;
        nums=new int[m][n];
        tree = new int[m+1][n+1];
        for (int i = 1; i <=m; i++) {
            for (int j = 1; j <=n; j++) {
                tree[i][j]=tree[i][j-1]+tree[i-1][j]-tree[i-1][j-1]+matrix[i-1][j-1];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                nums[i][j]=matrix[i][j];
            }
        }
    }

    public void update(int row, int col, int val) {
        if (m == 0 || n == 0) return;
        int delta = val - nums[row][col];
        nums[row][col] = val;
        for (int i = 1; i <=m; i++) {
            for (int j = 1; j <=n; j++) {
                tree[i][j]=tree[i][j-1]+tree[i-1][j]-tree[i-1][j-1]+nums[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (m == 0 || n == 0) return 0;
        return tree[row2+1][col2+1]+tree[row1][col1]-tree[row1][col2+1]-tree[row2+1][col1];
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.update(1, 1, 10);
// numMatrix.sumRegion(1, 2, 3, 4);