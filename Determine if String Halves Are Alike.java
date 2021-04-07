class Solution {
    
    // tc - O(n) + O(n) = O(n)
    // sc - O(1)
    public boolean halvesAreAlike(String s) {
        int len = s.length();
        int splitintoTwoEqualParts = len/2;
        int cnt1 = 0, cnt2 = 0;
        for(int i = 0; i < len/2; i++) {
            if(s.charAt(i) == 'A' || s.charAt(i) == 'E' || s.charAt(i) == 'I' || s.charAt(i) == 'O'
              || s.charAt(i) == 'U' || s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u') {
                cnt1++;
            }
        }
        
        for(int i = len-1; i >= len/2; i--) {
            if(s.charAt(i) == 'A' || s.charAt(i) == 'E' || s.charAt(i) == 'I' || s.charAt(i) == 'O'
              || s.charAt(i) == 'U' || s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u') {
                cnt2++;
            }
        }
        if(cnt1 == cnt2) {
            return true;
        }
        return false;
    }
}
