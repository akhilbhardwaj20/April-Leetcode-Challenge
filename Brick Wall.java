class Solution {
    
    // TC - O(no of rows * average length of the given list)
    // SC - O(1)
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;  // variable to hold the maximum edges that are not crossed
        for(List<Integer> row : wall) {
            int sum = 0; // stores the prefix sum for each iteration of rows
            for(int i = 0; i < row.size()-1; i++) {
                sum += row.get(i);
                map.put(sum, map.getOrDefault(sum,0) + 1);
                count = Math.max(count, map.get(sum));
            }
        }
        return wall.size() - count;
    }
}
