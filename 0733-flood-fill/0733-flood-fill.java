class Solution {
    public void dfs(int[][] image, int sr, int sc, int color, int newColor) {
        if (sr >= image.length || sr < 0 || sc >= image[0].length || sc < 0 || image[sr][sc] == newColor || image[sr][sc] != color) return;

        image[sr][sc] = newColor;
        dfs(image , sr+1 , sc ,color ,newColor);
        dfs(image , sr-1 , sc,color ,newColor);
        dfs(image , sr , sc+1,color ,newColor);
        dfs(image , sr , sc-1,color ,newColor);

    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        dfs(image, sr, sc, image[sr][sc], color);
        return image;
    }
}


// class Solution {
// public:
//     void dfs(vector<vector<int>> &image , int sr , int sc,int color , int newcolor){

//         if(sr >= image.size() || sr < 0 || sc >= image[0].size() || sc < 0 || image[sr][sc] == newcolor || image[sr][sc]!=color){
//             return;
//         }
//         image[sr][sc] = newcolor;
//         dfs(image , sr+1 , sc ,color ,newcolor);
//         dfs(image , sr-1 , sc,color ,newcolor);
//         dfs(image , sr , sc+1,color ,newcolor);
//         dfs(image , sr , sc-1,color ,newcolor);
//     }
//     vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {
//         dfs(image , sr,sc,image[sr][sc],color);
//         return image;
//     }
// };