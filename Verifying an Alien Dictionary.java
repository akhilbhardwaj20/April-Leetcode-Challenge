class Solution {
    // TC - O(n2)- sincewe are comparing two strings s1 and s2 together inside while loop
    // Sc - O(1) - since the length == 26 which is constant 
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        int weight = 1;      // variable used for extracting the weight of each character in order 
        for(char c : order.toCharArray()) {
            map.put(c,weight);
            weight += 1;  // increase its value by 1 for the nwxt iteration     
        }
        for(int i = 0; i < words.length - 1; i++) {
            String first = words[i];
            String second = words[i+1];
            if(!helper(first, second, map)) {
                return false;
            }
        }
        return true;
    }
    private boolean helper(String s1, String s2, Map<Character, Integer> map) {
        // use two pinter approach
        int i1 = 0;
        int i2 = 0;
        while(i1 < s1.length() && i2 < s2.length()) {
            if(s1.charAt(i1) != s2.charAt(i2)) {// if both the characters at i is different comparetheir weights
                if(map.get(s1.charAt(i1)) < map.get(s2.charAt(i2))) {
                    return true;
                } else {
                    return false;
                }
            }
            i1++;
            i2++;
        }
        // corner case : s1 = "hello"  s2 = "hell"
        if(s1.length() > s2.length()) {
            return false;
        }
        return true;
    }
}
