class Solution {
    // TC - O(n) since we are iterating over entire string only once
    // SC - O(n) since we are using stack 
    public String removeDuplicates(String s, int k) {
        Stack<Pair<Character,Integer>> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(stack.isEmpty() || stack.peek().getKey() != c) {
                // if the stack is empty or the element at the top of st is not same as current charadcter c
                stack.push(new Pair(c,1));
            } else {
                // matching case , pop the pair out and increase the freq of the matching element by 1
                Pair<Character, Integer> updated = stack.pop();
                stack.push(new Pair(updated.getKey(), updated.getValue() + 1));
                // if the frq of top element equals k pop the element
                if(stack.peek().getValue() == k) {
                    stack.pop();
                }
            }
        }
        // build our answer string
        
        String ans = "";
        while(!stack.isEmpty()) {
            // pull the topmost elem from stack
            Pair<Character, Integer> updated = stack.pop();
            // Add as many characters as that of frequency of topmost element
            int freq = updated.getValue();
            while(freq-- > 0) {
                ans = updated.getKey() + ans;
            }
        }
        return ans;
    }
}
