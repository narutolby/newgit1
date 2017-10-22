public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int count = 0;
        int[] xx = {1, -1, 0, 0};
        int[] yy = {0, 0, 1, -1};
        int m = grid.length;
        int n = grid[0].length;
        int sum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    sum++;
                    for (int k = 0; k < 4; k++) {
                        int x = i + xx[k];
                        int y = j + yy[k];
                        if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                            count++;
                        }
                    }
                }
            }
        }
        return sum * 4 - count;
    }
}
