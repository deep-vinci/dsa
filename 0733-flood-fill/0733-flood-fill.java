class Solution {
    static int vis[][];
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public int[][] dfs(int[][] vis, int[][] image, int x, int y, int c, int m, int n, int cc) {
        vis[x][y] = 1;
        image[x][y] = c;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                if (vis[nx][ny] == 0 && image[nx][ny] == cc) {
                    image[nx][ny] = c;
                    dfs(vis, image, nx, ny, c, m, n,cc);
                }
            }
        }

        return image;
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;

        vis = new int[m][n];    
        int cc = image[sr][sc];
        return dfs(vis, image, sr, sc, color, m, n, cc);
    }
}