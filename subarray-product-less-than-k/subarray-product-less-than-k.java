class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k==0) return 0;
        int i = 0 ; 
        int j = 0 ; 
        int count = 0 ; 
        int prod = 1 ; 
        while(j<nums.length){
            prod = prod*nums[j];       
                while(prod >= k && i <= j){
                    prod = prod/nums[i];
                    i++;
                }
            //at this point of the code we are garunteed to have an answer. 
            count += j-i+1;

            j++;
        }
        return count;
    }
    
}