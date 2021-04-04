class MyCircularQueue {
    int F;
    int R;
    boolean noElementsPresent;
    int []cQueue = null;
    
    public MyCircularQueue(int k) {
        // first allocate memory of sizw = 'k'
        this.cQueue = new int[k];
        this.noElementsPresent = true; // in the base case there are no elements present in the que
        this.F = 0;
        this.R = 0;
    }
    
    //O(1)
    public boolean enQueue(int value) {
        if (this.isFull()) {
            return false;
        } else {
            this.noElementsPresent = false;
            cQueue[R] = value;
            R = (R + 1) % cQueue.length;
            return true;  
        }
    }
    
    //O(1)
    public boolean deQueue() {
      if(this.isEmpty()) {
          return false;
      }  else {
          F = (F + 1) % cQueue.length;
          if(F==R) {
              this.noElementsPresent = true;
          }
          return true;
      }
    }
    
    //O(1)
    public int Front() {
        if(this.isEmpty()) {
            return -1;
        } else {
            return cQueue[F]; 
        }
    }
    
    O(1)
    public int Rear() {
        if(this.isEmpty()) {
            return -1;
        } else {
            if(R==0) {
                return cQueue[cQueue.length-1];  // return the element at the last index
            } else {
                return cQueue[R-1];
            }
        }
    }
    //O(1)
    public boolean isEmpty() {
        
        return this.noElementsPresent;
    }
    
    public boolean isFull() {
        return F==R && !this.noElementsPresent;  // or F==R && !this.isEmpty()
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
