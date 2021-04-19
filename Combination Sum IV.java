class Solution {
  // same as coin change problem
    // TC - O(target * no. of elements)
    // SC - O(n) since we are using an extra array which uses extra space
    // bottom - up dp 
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        for(int i = 1; i <= target; i++) {
            for(int n : nums) {
                if(i - n >= 0) {
                    dp[i] += dp[i-n];
                }
            }
        }
        return dp[target];
    }
}
// Follow up:
// If negative numbers exist in input array, then the combinations could be infinite length. For example, nums = [-1, 1] and target = 1. There could have infinite (-1, 1) pairs plus a single 1.

// If we limit the length of the combination sequence, the problem will have a finite solution.
