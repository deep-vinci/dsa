class Solution {
    public int findJudge(int n, int[][] trust) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[n+1]; Arrays.fill(indegree, 0);
        int[] outdegree = new int[n+1]; Arrays.fill(outdegree, 0);

        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < trust.length; i++) {
            adj.get(trust[i][0]).add(trust[i][1]);

            outdegree[trust[i][0]]++;
            indegree[trust[i][1]]++;
        }    

        System.out.println(Arrays.toString(indegree));
        System.out.println(Arrays.toString(outdegree));
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == n - 1 && outdegree[i] == 0) {
                return i;
            }
        }


        return -1;
    }
}