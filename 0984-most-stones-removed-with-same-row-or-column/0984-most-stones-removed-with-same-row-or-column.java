import java.util.*;

class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        boolean[] vis = new boolean[n];
        int components = 0;

        // Count connected components
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                components++;
                dfs(i, adj, vis);
            }
        }

        return n - components;
    }

    private void dfs(int node, List<List<Integer>> adj, boolean[] vis) {
        vis[node] = true;
        for (int nei : adj.get(node)) {
            if (!vis[nei]) {
                dfs(nei, adj, vis);
            }
        }
    }
}
