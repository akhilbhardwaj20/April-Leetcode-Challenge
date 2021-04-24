class Solution {
  // TC - O(n) where n is the length of the string
  // TC - O(1) 
    public int countBinarySubstrings(String s) {
        int prev = 0, curr = 1, res = 0;
        for(int i = 1; i<s.length(); i++) {
            if(s.charAt(i-1) != s.charAt(i)) {
                res += Math.min(prev, curr);
                prev = curr;
                curr = 1;
                
            } else {
                curr++;
            }
        }
        return res + Math.min(prev, curr);
    }
}
