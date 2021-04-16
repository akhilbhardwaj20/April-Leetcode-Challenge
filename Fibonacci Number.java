class Solution {
  // recursive approach
// TC - O(n) 
// Sc - O(n) since stack space is used
    public int fib(int n) {
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        return fib(n-1) + fib(n-2);
    }
}
