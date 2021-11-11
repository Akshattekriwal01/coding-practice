/*
[-3,2,-3,4,2]
           i
  
 -3
 -1
 -4
 0
 2
(min + 1) 
 
 
 
 
 
*/

class Solution {
    public int minStartValue(int[] nums) {
        int min = Integer.MAX_VALUE ;
        int sum = 0  ;
        for(int i= 0 ; i < nums.length  ; i++){
            sum += nums[i] ; 
            min = Math.min(min, sum);
        }  
        if(min < 0)
        return Math.abs(min) + 1;
        else return 1;
       
    }
}