class Solution {
    // TC - O(n) since we are iterating through the given nodes only once
    // SC - O(n) since we are using stack space 
    public List<Integer> preorder(Node root) {
        Stack<Node> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        stack.push(root);
        while(!stack.isEmpty()) {
            Node curr = stack.pop(); // pop the element at top of stack
            list.add(curr.val);  // add the current node value to the list
            // add all the popped nodes child in reverse order 
            for(int i = curr.children.size()-1; i >= 0; i--) {
                stack.push(curr.children.get(i));
            }
        }
        return list;
    }
}
