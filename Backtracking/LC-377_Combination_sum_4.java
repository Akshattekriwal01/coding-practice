class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] memo = new int[target+1];
        Arrays.fill(memo,-1);
        return helper(nums,target, memo);
    }
    public int helper(int[] nums, int target, int[] memo){ 
         if (target < 0){
            return 0;
        }
        else if(target == 0){
            return 1;
        }else if(memo[target] != -1){
            return memo[target];
        }
        else{
            int n = 0 ;
          for(int i = 0 ; i < nums.length ; i ++){     
                n +=   helper(nums,target-nums[i],memo)  ;
          }
            memo[target] = n ;
            return  n;
        }
    }
}