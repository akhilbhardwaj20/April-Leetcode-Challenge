class Solution {
    // tc - O(n^2)
    public boolean isIdealPermutation(int[] A) {
        for(int i = 0; i < A.length; i++) {
            for(int j = i+1; j < A.length; j++) {
                if(A[i] > A[j]) {
                    if(i != j + 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

// think about the problem in an abstract way, local inversions are actually swaps between two adjacent elements only. So whenever we detect |i - A[i]| > 1, we return false.

class Solution {
    // tc - O(n)
    // sc - O(1)
    public boolean isIdealPermutation(int[] A) {
        for(int i = 0; i < A.length; i++) {
            if(Math.abs(i-A[i]) > 1) {
                return false;
            }
        }
        return true;
    }
}
