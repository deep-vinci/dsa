    package graphs;
    import java.util.*;

    class BFS {
        static int vis[];
        public static void BFSTraversal(ArrayList<ArrayList<Integer>> adj, int n) {
            Queue<Integer> queue = new LinkedList<>();

            queue.add(n);   
            vis[n] = 1;

            
            while(!queue.isEmpty()) {
                int x = queue.poll();

                System.out.println(x);

                for (int y : adj.get(x)) {
                    if (vis[y] == 0) {
                        vis[y] = 1;
                        queue.add(y);
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
            BFSTraversal(adj, 0);
        }
    }
