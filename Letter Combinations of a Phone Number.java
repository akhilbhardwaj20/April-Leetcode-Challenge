class Solution {
// TC - O(4^n.n)
// SC- O(n) 

    Map<Character, String> map = new HashMap<>();
    
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        
        if(digits == null || digits.length() == 0) {
            return res;
        }
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        
        helper(0,"",digits);
        return res;
    }
    public void helper(int idx, String current, String digits) {
        if(idx == digits.length()) {  // if we hadalready computed all the possible combinations we just return
            res.add(current);
            return;
        }
        String letter = map.get(digits.charAt(idx));
        for(int i=0; i<letter.length(); i++) {
            String str = letter.substring(i, i+1);
            helper(idx+1, current.concat(str), digits);
        }
    }
    
}
