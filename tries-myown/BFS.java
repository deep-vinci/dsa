import java.util.*;

class BFS {
    static int vis[];
    public static void BFSTraversal(ArrayList<ArrayList<Integer>> adj, int n) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(n);
        vis[n] = 1;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.println(node);

            for (int it : adj.get(node)) {
                if (vis[it] == 0) {
                    vis[it] = 1;
                    queue.add(it);
                }     
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
        BFSTraversal(adj, 0);
    }
}
