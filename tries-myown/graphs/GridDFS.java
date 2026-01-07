package graphs;

class GridDFS {
    static int vis[][];
    public static void DFS(int[][] edges, int x, int y, int m, int n) {
        vis[x][y] = 1;
        System.out.println(x + " " + y);
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                if (vis[nx][ny] == 0 && edges[nx][ny] == 1) {
                    DFS(edges, nx, ny, m, ny);
                }
            } 
        }
    }
    public static void main(String[] args) {
        int[][] edges = {
            {0, 1, 0, 1},
            {1, 0, 1, 0},
            {0, 1, 0, 1},
            {1, 0, 1, 0}
        };



        int m = edges.length;
        int n = edges[0].length;
        vis = new int[m][n];

        DFS(edges, 0, 0, m, n);
    }
}