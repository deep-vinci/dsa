class Solution {
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int perimeter = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    perimeter += 4;
                    if (i + 1 < rows && grid[i + 1][j] == 1) perimeter -= 2;
                    if (j + 1 < cols && grid[i][j + 1] == 1) perimeter -= 2;
                }
            }
        }
        return perimeter;
    }
}
