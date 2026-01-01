class Solution {
    int[] visited;
    public boolean traverse(ArrayList<ArrayList<Integer>> adj, int source, int destination) {
        if (source == destination) return true;
        if (visited[source] == 1) return false;
        boolean ans = false;
        visited[source] = 1;
        for (int x : adj.get(source)) {
            ans = ans || traverse(adj, x, destination);
        }

        return ans;
    }

    // public boolean bfs(ArrayList<ArrayList<Integer>> adj, int source, int destination) {
        
    // }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        visited = new int[n]; Arrays.fill(visited, 0);

        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }    
        // System.out.println(adj);

        // return traverse(adj, source, destination);

        Queue<Integer> q = new LinkedList<>();
        visited[source] = 1;
        q.add(source);
        while(!q.isEmpty()) {
            int u = q.peek();
            if (u == destination) return true;
            q.poll();
            // visited[u] = 1;
            for(int x: adj.get(u)) {
                if(visited[x] == 0) {
                    visited[x] = 1;
                    q.add(x);
                }
            }
        }

        return false;
    }
}