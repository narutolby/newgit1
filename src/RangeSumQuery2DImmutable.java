public class NumMatrix {

    int[][]sumMatrix = null;
    public NumMatrix(int[][] matrix) {
        if(matrix == null || matrix[0].length == 0){
            return;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        sumMatrix = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i == 0 && j == 0){
                    sumMatrix[i][j] = matrix[i][j];
                }else if(i == 0){
                    sumMatrix[i][j] = sumMatrix[i][j-1]+matrix[i][j];
                }else if(j == 0){
                    sumMatrix[i][j] = sumMatrix[i-1][j]+matrix[i][j];
                }else{
                    sumMatrix[i][j] = sumMatrix[i-1][j] + sumMatrix[i][j-1] - sumMatrix[i-1][j-1];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {

    }
}
