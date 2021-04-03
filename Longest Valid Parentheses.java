class Solution {
    
    // tc - O(n) since we traversed the string once
    // sc - O(n) since we created a stack
    public int longestValidParentheses(String s) {
        if(s.length() == 0) {
            return 0;
        }
        Stack<Integer> indexes = new Stack<>();
        indexes.add(-1);
        int length = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                indexes.push(i);
            } else {
                indexes.pop();
                if(indexes.isEmpty()) {
                    indexes.push(i);
                    continue;
                }
                int currentLength = i-indexes.peek();
                if(length < currentLength) {
                    length = currentLength;
                }
            }
        }
        return length;
    }
}
