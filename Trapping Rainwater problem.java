// Problem link ------->      https://practice.geeksforgeeks.org/problems/trapping-rain-water-1587115621/1#
static int trappingWater(int arr[], int n) { 
        // TC - O(n)
        // TC- O(n) as we have creatd two arrays
       int ans = 0;
       
      int[] left = new int[n];
      int[] right = new int[n];
      left[0] = arr[0];
       for(int i = 1; i < n; i++) {
           left[i] = Math.max(left[i-1], arr[i]);
           
       }
       right[n-1] = arr[n-1];
       for(int i = n-2; i >= 0; i--) {
           right[i] = Math.max(right[i+1], arr[i]);
       }
       for(int i = 0; i < n; i++) {
           ans += ((int)Math.min(left[i],right[i]) - arr[i]);
       }
       
        return ans;
    } 
}


