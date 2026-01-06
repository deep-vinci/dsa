
class Solution {
    List<List<Integer>> adj;
    boolean[] vis;

    void dfs(int node) {
        vis[node] = true;
        for (int nei : adj.get(node)) {
            if (!vis[nei]) {
                dfs(nei);
            }
        }
    }

    public int makeConnected(int n, int[][] connections) {
        int edges = connections.length;
        if (edges < n - 1) return -1;

        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] e : connections) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        vis = new boolean[n];
        int c = 0;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(i);
                c++;
            }
        }

        System.out.println(c);

        return c - 1;
    }
}
