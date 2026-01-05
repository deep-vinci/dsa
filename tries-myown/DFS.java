import java.util.*;

class DFS {
    static int vis[];
    public static void DFSTraversal(ArrayList<ArrayList<Integer>> adj, int n) {
        vis[n] = 1;
        System.out.println(n);
        for (int it : adj.get(n)) {
            if (vis[it] == 0) {
                DFSTraversal(adj, it);
            }
        }
    }

    public static void main(String[] args) {
        int[][] edges = {
            {0, 1},
            {0, 2},
            {1, 2},
            {2, 3},
            {2, 4}
        };

        int n = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u); // undirected
        }

        System.out.println(adj);
        vis = new int[n];
        DFSTraversal(adj, 0);
    }
}
