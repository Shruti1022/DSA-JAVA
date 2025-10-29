class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int i, j;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] ans = new int[m][n];

        if (obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1) return 0;
        ans[0][0] = 1;

        for(i = 1; i<m; i++){
            ans[i][0] = (obstacleGrid[i][0] == 0 && ans[i-1][0] == 1) ? 1:0;
        }

         for(j = 1; j<n; j++){
            ans[0][j] = (obstacleGrid[0][j] == 0 && ans[0][j-1] == 1) ? 1:0;
        }

        for(i = 1; i<m; i++){
            for(j = 1; j<n; j++){
                if(obstacleGrid[i][j] == 1) 
                    ans[i][j] = 0;
                else{
                    ans[i][j] = ans[i-1][j] + ans[i][j-1];
                }
            }
        }
        return ans[m-1][n-1];
    }
}