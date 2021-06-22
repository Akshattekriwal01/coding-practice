class Solution {
    public boolean canPartition(int[] nums) {
        
       int sum = 0;
        
       
        for(int i =0 ; i<nums.length;i++){
            sum = sum+nums[i];
        }
        if((sum & 1) == 0 ){
            Boolean[][] dp = new Boolean[nums.length+1][sum+1];
            sum = sum/2;
            return helper(sum, nums, nums.length, dp);
        }else{
            return false;
        }
    }
    
    public Boolean helper(int sum, int[] nums, int n, Boolean[][] dp){
        if(sum ==  0){
            return true;
            // negative base cases is not required because sum - nums[n-1] >= 0 in my solution. 
        }else if (sum != 0 &&   n ==0){            
            return false;
        }else if(dp[n][sum] != null){
            return dp[n][sum];
        }
        else{
            if(nums[n-1] <= sum){
               dp[n][sum]= helper(sum- nums[n-1], nums, n-1, dp)|| helper(sum, nums, n-1,dp);
                return dp[n][sum];
            }else{
                dp[n][sum]= helper(sum, nums , n-1,dp);
                return dp[n][sum];
            }
        }
    }
}