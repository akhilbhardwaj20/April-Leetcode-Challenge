// BFS solution using queues
// TC - O(n)
// SC - O(n/2)
class Solution {
    public int deepestLeavesSum(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int sum = 0;
        Queue<TreeNode> q =  new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            
            int size = q.size();
            sum = 0;
            while(size-- > 0) {
               TreeNode n = q.poll();
                sum += n.val;
               if(n.left != null) {
                   q.offer(n.left);
               }
               if(n.right != null) {
                   q.offer(n.right);
               }
                
            }
            
        }
        return sum;
    }
}


class Solution {

// TC - O(n)
// SC - O(n)  // recursion stack space
    private int maxDepthSum = 0;
    private int maxDepthSeen = 0;
    public int deepestLeavesSum(TreeNode root) {
        if(root == null) {
            return 0;
        }
        helper(root,0);
        return maxDepthSum;
    }
    private void helper(TreeNode node, int level) {
        if(node == null) {
            return;
        }
         
            if(level == maxDepthSeen) {
                maxDepthSum += node.val;
            } else if(level > maxDepthSeen) {
                maxDepthSum = node.val;
                maxDepthSeen = level;
            }
        helper(node.left, level + 1);
        helper(node.right, level + 1);
    }
}
