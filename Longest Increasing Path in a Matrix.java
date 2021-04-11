class Solution {
    private int[][] DIRECTIONS = {{1,0},{-1,0},{0,1},{0,-1}};
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return 0;
        }
        int n = matrix.length, m = matrix[0].length, longestPath = 0;
        int[][] cache = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int longest = longestIncreasingPath(matrix, cache, n, m, i, j); // currentPos --> i,j
                longestPath = Math.max(longestPath, longest);
            }
        }
        return longestPath;
    }
    private int longestIncreasingPath(int[][] matrix, int[][] cache, int n, int m, int i, int j) {
        // check if we have already visited the position in the cached array
        if(cache[i][j] > 0) { // if already visited     #memization step
            return cache[i][j];
        }
        int max = 0;
        for(int[] direction : DIRECTIONS) {
            // create coordinates x and y 
            int x = direction[0] + i;
            int y = direction[1] + j;
            
            // check for valid coordinate
            if(x > -1 && y > -1 && x < n && y < m && matrix[x][y] > matrix[i][j] ) {
                int longest = longestIncreasingPath(matrix, cache, n, m, x, y);  // i,j updated to x,y
                max = Math.max(max,longest);
            }
        }
        cache[i][j] = max + 1;
        return cache[i][j];        
    }
}

//Note : if we comment line no 19 then it will be a brute force approach
// TC- O(2*(n*m)) = O(n*m) where m = no of rows and m is the no of columns
// SC- O(n*m) since on ine n 8 we hava used a cache 
