class Solution {
    public int minPathSum(int[][] grid) {
        int rows= grid.length;
        int cols= grid[0].length;

        for(int i = 1; i<cols; i++){
            grid[0][i] += grid[0][i-1];
        }
        for(int j = 1; j<rows; j++){
            grid[j][0] += grid[j-1][0];
        }

        for(int j = 1; j<cols; j++){
            for(int i = 1; i<rows; i++){
                grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }
        return grid[rows-1][cols-1];
    }
}