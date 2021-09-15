/* brute force is n cubed . 
   sort the array. move from left to right. 
   a+b+c = 
   a = -(b+c); 2 sum for a 
   // so time complexity is O(n^2);
*/
class Solution {
   /*
   sort to avoid duplicates for history.
   2 sum for sorted is using high and low.
   in case of high and low 
   */
    
    
 public List<List<Integer>> threeSum(int[] num) {
// sorting is to avoid duplicated, we don't look at the past. 
     // since the number is sorted, we can use 2 pointers to find if the sum exist
    
     Arrays.sort(num); // cannot use lambda function for this. 
     List<List<Integer>> res = new ArrayList<List<Integer>>() ;
    for(int i = 0 ; i < num.length - 1  ; i++){
        if(i > 0 && num[i] == num[i-1]) continue ;
        int target = -1 * num[i] ; 
        int l = i+1 ; 
        int r = num.length - 1;
          List<Integer> ans = new ArrayList<Integer>() ;
        while(l < r){
            int sum = num[l]+num[r];
        if(sum > target ) r-- ;
        else if( sum < target) l++ ;
        else { // sum == target 
            res.add(Arrays.asList(num[l],num[r],num[i]));
           while( l < r && num[l] == num[l+1]) l++ ;
           while( l < r && num[r] == num[r-1]) r-- ;
            l++ ;
            r-- ;
        }
     }
    
    }
     return res;
 }   
       
}