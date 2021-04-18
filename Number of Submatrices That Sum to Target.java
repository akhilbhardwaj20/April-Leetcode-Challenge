class Solution {
  // prerequisite  -----> subarray sum equals k 
  // Intuition : compute prefix sum for each cell of the matrix in place and store its occurence in a hashMap.
// TC - O(n2) since we have to go through each cell of the matrix
// SC - O(1) as we have not used any extra space
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length,n=matrix[0].length;
        
        for(int row =0;row<m;row++){
            for(int col=1;col<n;col++){
                matrix[row][col]+=matrix[row][col-1];
            }
        }
        int count=0;
        
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                Map<Integer,Integer> map = new HashMap<>();
                map.put(0,1);
                int sum=0;
                
                for(int row=0;row<m;row++){
                    sum += matrix[row][j] - (i>0 ? matrix[row][i-1] : 0);
                    count += map.getOrDefault(sum-target,0);
                    map.put(sum,map.getOrDefault(sum,0)+1);
                }
                
            }
        }
        
        return count;
    }
}
