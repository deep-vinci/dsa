class Solution {
    static int[] vis;

    public void dfs(ArrayList<ArrayList<Integer>> adj, int n) {
        vis[n] = 1;
        for (int c: adj.get(n)) {
            if (vis[c] == 0) {
            dfs(adj, c);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        // int m = isConnected.length;
        int n = isConnected.length;
        vis = new int[n];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adj.get(i).add(j);
                }
            }
        }
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                dfs(adj, i);
                count++;
            }
        }

        return count;
    }
}

// class Solution {
//     static int vis[][];
//     static int[] dx = {-1,0,1,0};
//     static int[] dy = {0,1,0,-1};

//     public void bfs(int[][] g, int x, int y, int m, int n) {
//         Queue<int[]> q = new LinkedList<>();
//         q.add(new int[]{x, y});
//         vis[x][y] = 1;

//         while(!q.isEmpty()){
//             int[] el = q.poll();

//             for (int i = 0; i < 4; i++) {
//                 int nx = el[0] + dx[i];
//                 int ny = el[1] + dy[i];

//                 if (nx >= 0 && nx < m) {
//                     if (ny >=0 && ny < n) {
//                         if (vis[nx][ny] == 0 && g[nx][ny] == 1) {
//                             // bfs(g, nx, ny);
//                             vis[nx][ny] = 1;
//                             q.add(new int[]{nx, ny});
//                         }
//                     }
//                 }
//             }
//         }
//     }
//     public int findCircleNum(int[][] isConnected) {
//         int m = isConnected.length;
//         int n = isConnected[0].length;
//         vis = new int[m][n];
//         int pc = 0;

//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 if (vis[i][j] == 0 && isConnected[i][j] == 1) {
//                     bfs(isConnected, i, j, m, n);
//                     pc++;    
//                 }
//             }
//         }

//         return pc;
//     }
// }