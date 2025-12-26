class Solution {

    public int paths(int[][] arr, int m, int n) {
        if (m == 0 && n == 0) return 1; 
        if (m == 1 || n == 1) return 1;

        if (arr[m][n] != -1) {
            return arr[m][n];
        }

        int path = paths(arr, m - 1, n) + paths(arr, m, n - 1);
        return arr[m][n] = path;
    }

    public int uniquePaths(int m, int n) {
        int[][] arr = new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                arr[i][j] = -1;
            }
        }
        System.out.println(Arrays.deepToString(arr));
        return paths(arr, m, n);
    }
}