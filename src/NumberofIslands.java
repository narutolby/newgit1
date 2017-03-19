/**
 * @author boyang.lby
 * @date 3/12/17
 * @description
 */
public class NumberofIslands {
    public int numIslands(char[][] grid) {
        int ret = 0;
        if (grid == null || grid.length == 0) {
            return ret;
        }
        int n = grid.length,
                m = grid[0].length;
        int[][] marked = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '0' || marked[i][j] == 1) {
                    continue;
                }
                dfs(grid, marked, i, j, n, m);
                ret++;
            }
        }
        return ret;
    }

    public void dfs(char[][] grid, int[][] marked, int i, int j, int n, int m) {
        marked[i][j] = 1;
        if (i != n - 1 && grid[i + 1][j] == '1' && marked[i + 1][j] != 1) {
            dfs(grid, marked, i + 1, j, n, m);
        }
        if (j != m - 1 && grid[i][j + 1] == '1' && marked[i][j + 1] != 1) {
            dfs(grid, marked, i, j + 1, n, m);
        }
        if (i != 0 && grid[i - 1][j] == '1' && marked[i - 1][j] != 1) {
            dfs(grid, marked, i - 1, j, n, m);
        }
        if (j != 0 && grid[i][j - 1] == '1' && marked[i][j - 1] != 1) {
            dfs(grid, marked, i, j - 1, n, m);
        }
    }
}
