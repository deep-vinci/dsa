class Solution {

    public void dfs(int i, int j, char[][] board, int[][] vis, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] == '.' || vis[i][j] == 1) {
            return;
        }

        vis[i][j] = 1;

        dfs(i + 1, j, board, vis, m, n);
        dfs(i, j + 1, board, vis, m, n);
    }

    public int countBattleships(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int count = 0;

        int[][] vis = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X' && vis[i][j] == 0) {
                    dfs(i, j, board, vis, m, n);
                    count++;
                }
            }
        }

        return count;
    }
}


// class Solution {
// public:
//     void dfs(int i,  int j , vector<vector<char>>& board ,vector<vector<int>>& vis,int m,int n){
        
//         if(i<0||i>=m||j<0||j>=n||board[i][j]=='.'||vis[i][j]==1)return;
//         vis[i][j] = 1;
//         dfs(i+1,j,board,vis,m,n);
//         dfs(i,j+1,board,vis,m,n);
//     }
//     int countBattleships(vector<vector<char>>& board) {
//         int m = board.size();
//         int n = board[0].size();
//         int count = 0;
//         vector<vector<int>> vis(m,vector<int>(n,0));
//         for(int i = 0; i<m;i++){
//             for(int j=0;j<n;j++){
//                 if(board[i][j] == 'X' && vis[i][j] == 0){
//                     dfs(i,j,board,vis,m,n);
//                     count++;
//                 }
//             }
//         }
//         return count;
//     }
// };