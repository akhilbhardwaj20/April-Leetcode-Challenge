import java.util.*;
// Create a tuple class called Node which contains 3 parameters as follows
// TC -O(logn) for each poll and offer and we do it for k elements if k < n
// so overall Tc - O(min(n,k) + klog n) = klogn

class Solution {
    
    

    public int kthSmallest(int[][] matrix, int k) {
        
         class Node {
          int row;
          int col;
          int val;
    Node(int row, int col, int val) {
        this.row = row;
        this.col = col;
        this.val = val;
    }
}
          PriorityQueue<Node> pq = new PriorityQueue<Node>((a,b) -> a.val - b.val);
        //add first row to the heap
        for(int i = 0; i < matrix[0].length; i++) {
            pq.add(new Node(0,i,matrix[0][i]));
        }
        for(int i=1; i<k; i++) {
            Node top = pq.poll();
            if(top.row == matrix.length - 1) {
                continue;
            }
            pq.add(new Node(top.row+1, top.col, matrix[top.row+1][top.col]));
        }
        return pq.poll().val;
        
    }
}
