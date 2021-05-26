class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    
    
    static int knapSack(int w, int wt[], int val[], int n) 
    { 
         int[][] dp = new int[n+1][w+1];
         for(int[] arr  : dp)
            Arrays.fill(arr,-1);
        
     return   helper(w, wt, val , n,dp);
        
        
    }
    
    
    public static int helper(int w , int[] wt , int val[] , int n, int [][] dp){
        if(n == 0 || w == 0)
            return 0;
        else if (dp[n][w] != -1)
            return dp[n][w];
        else{
            if (wt[n-1] <= w ){
                dp[n][w] = Math.max(val[n-1]+helper(w-wt[n-1], wt , val, n-1,dp), helper(w,wt ,val,n-1,dp));
                return dp[n][w] ;
                
            }else{
                dp[n][w]=helper(w, wt , val , n-1,dp);
            
                return dp[n][w];
            }
        }
    } 