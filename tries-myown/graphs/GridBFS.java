package graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class GridBFS {
    static int vis[][];    
    public static void bfs(int[][] edges, int x, int y, int m, int n) {
        int dx[] = {-1, 0, 1, 0};
        int dy[] = {0, 1, 0, -1};

        Queue<int[]> q = new LinkedList<>();
        vis[x][y] = 1;
        q.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] el = q.poll();

            System.out.println("visited: " + Arrays.toString(el));
            for (int i = 0; i < 4; i++) {
                int ix = el[0] + dx[i];
                int iy = el[1] + dy[i];

                if (ix >= 0 && ix < m && iy >= 0 && iy < n) {
                    if (vis[ix][iy] == 0 && edges[ix][iy] == 1) {
                        vis[ix][iy] = 1;
                        q.add(new int[]{ix, iy});
                    }
                }
            }
        }

    }
    
    public static void displayBeforeAfter(int[][] edges) {
        System.out.println("Before:");
        int m = edges.length;
        int n = edges[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(edges[i][j] == 1 ? "1 " : ". ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("After (visited marked with \u25A0):");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (edges[i][j] == 1 && vis[i][j] == 1) {
                    System.out.print("\u25A0 ");
                } else if (edges[i][j] == 1) {
                    System.out.print("1 ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[][] edges = {
            {1, 1, 1, 0, 0, 0, 0, 0},
            {0, 0, 1, 1, 1, 1, 0, 0},
            {0, 0, 0, 0, 0, 1, 1, 1},
            {1, 1, 1, 1, 0, 0, 0, 1},
            {1, 0, 0, 1, 1, 1, 0, 1},
            {1, 1, 0, 0, 0, 1, 1, 1},
            {0, 1, 1, 1, 0, 0, 0, 1},
            {0, 0, 0, 1, 1, 1, 1, 1}
        };



        int m = edges.length;
        int n = edges[0].length;
        vis = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (edges[i][j] == 1 && vis[i][j] == 0) {
                    bfs(edges, i, j, m, n);
                    // break;
                }
            }
        }
        // show before/after (before = input grid, after marks visited cells with 'V')
        displayBeforeAfter(edges);
        // BFS(edges, 0, 0, m, n);
    }
}