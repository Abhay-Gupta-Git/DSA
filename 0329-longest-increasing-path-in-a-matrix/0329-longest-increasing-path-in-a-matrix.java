class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int length = dfs(matrix, dp, i, j);
                ans = Math.max(ans, length);
            }
        }
        return ans;
    }
    public int dfs(int[][] matrix, int[][] dp, int i, int j) {
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        int ans = 1;
        // Up
        if (i > 0 && matrix[i - 1][j] > matrix[i][j]) {
            ans = Math.max(ans, 1 + dfs(matrix, dp, i - 1, j));
        }

        // Down
        if (i < matrix.length - 1 && matrix[i + 1][j] > matrix[i][j]) {
            ans = Math.max(ans, 1 + dfs(matrix, dp, i + 1, j));
        }

        // Left
        if (j > 0 && matrix[i][j - 1] > matrix[i][j]) {
            ans = Math.max(ans, 1 + dfs(matrix, dp, i, j - 1));
        }

        // Right
        if (j < matrix[0].length - 1 && matrix[i][j + 1] > matrix[i][j]) {
            ans = Math.max(ans, 1 + dfs(matrix, dp, i, j + 1));
        }

        dp[i][j] = ans;

        return ans;
    }
}