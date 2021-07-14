class Solution {
    public int rob(int[] nums) {
    // max possible sum of non adjecent element. 
        int n = nums.length ;
        int[][] sumTillIndex = new int[nums.length][2]; 
        
        sumTillIndex[0][0] =  nums[0] ;//include the first sum ;
        sumTillIndex[0][1] = 0 ; // exclude the first sum;

        for(int i = 1; i < nums.length ; i++){
                                //previous excluded sum 
            sumTillIndex[i][0] = sumTillIndex[i-1][1]   + nums[i];
            sumTillIndex[i][1] = Math.max(sumTillIndex[i-1][1] , sumTillIndex[i-1][0]);
        }
        
        return Math.max(sumTillIndex[n-1][1] , sumTillIndex[n-1][0]);
        
    }
}