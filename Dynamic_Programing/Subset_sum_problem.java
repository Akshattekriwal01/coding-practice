public class Solution {
    public int solve(int[] A, int B) {
        Boolean[][] dp = new Boolean[A.length +1][B+1];
        for(Boolean[] arr: dp){
            Arrays.fill(arr,null);
        }
        
        if(helper(A,B,A.length,dp) == true)
        return 1;
        else 
        return 0;
        
    }
    public Boolean helper(int[] A, int B, int n, Boolean[][] dp ){
    
         if(B!=0 && n == 0){
             return false;
         }
        else if(B == 0 ){
            return true;
    
        }else if (dp[n][B] != null){
            return dp[n][B];
        }
        else{
            if(A[n-1] <= B){
             dp[n][B]=  helper(A,B-A[n-1],n-1,dp) || helper(A,B,n-1,dp);
            return dp[n][B];
            }else{
                dp[n][B] = helper(A,B,n-1,dp);
                return dp[n][B];
            }
        }
    }
}