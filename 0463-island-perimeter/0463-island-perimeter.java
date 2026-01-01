class Solution {
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int perimeter = 0;

        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    int sides = 4;

                    for (int[] d : dirs) {
                        int ni = i + d[0];
                        int nj = j + d[1];

                        if (ni >= 0 && nj >= 0 &&
                            ni < rows && nj < cols &&
                            grid[ni][nj] == 1) {
                            sides--;
                        }
                    }

                    perimeter += sides;
                }
            }
        }

        return perimeter;
    }
}