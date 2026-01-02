class Solution {
    public boolean dfs(ArrayList<ArrayList<Integer>> adj, int source, boolean[] vis, boolean[] path) {
        if (path[source] == true) return true;
        if (vis[source] == true) return false;
        boolean ans = false;

        path[source] = true;
        vis[source] = true;
        for (int x : adj.get(source)) {
            // ans = ans || dfs(adj, x, vis);
            // if (dfs(adj, x, vis, path)) return false;
            if (dfs(adj, x, vis, path)) { 
                return true;
            }
        }

        path[source] = false;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        boolean[] vis = new boolean[numCourses];
        boolean[] path = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < prerequisites.length; i++) {
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            
            adj.get(b).add(a);
        }

        System.out.println(adj);
        for (int i = 0; i < numCourses; i++) {
            if (!vis[i]) {
                if (dfs(adj, i, vis, path)) {
                    return false;
                }
            }
        }

        return true;

    }
}  