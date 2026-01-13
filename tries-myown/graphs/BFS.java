    package graphs;
    import java.util.*;

    class BFS {
        static int vis[];

        public static void BFS(ArrayList<ArrayList<Integer>> adj, int n) {
            Queue<Integer> q = new LinkedList<>();

            q.add(n);
            vis[n] = 1;

            while(!q.isEmpty()) {
                int top = q.poll();

                System.out.println(top);
                for (int el : adj.get(top)) {
                    if (vis[el] == 0) {
                        vis[el] = 1;
                        q.add(el);
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

            // System.out.println(adj);
            vis = new int[n];
            // BFSTraversal(adj, 0);
            BFS(adj, 0);
        }
    }
