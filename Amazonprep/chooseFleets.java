import java.util.*;
// basically this is coin change 2 on leetcode / unbounded knapsack
// availble coins are infinite is [2,4], target array[6,3,2] ans [2,0,1]; 
public class chooseFleets {
	 static Map<Integer,Integer> memo = new HashMap<Integer,Integer>();
	public static void main(String[] args) {
		
		int[] coins = {2,4};
		int[] array = {4,3,6};
		List<Integer> ans = new ArrayList<Integer>();
		
		for(int i = 0 ; i < array.length ; i++) {
			ans.add(change(coins,array[i]));
			System.out.println("----");
		}
		System.out.println(ans);
	}
	

	    public static int change( int[] coins, int amount) {
		        int[] dp = new int[amount + 1];
		        dp[0] = 1;        
		        for (int j = 0; j < coins.length; j++) {
		            for (int i = 1; i <= amount; i++) {
		                if (i - coins[j] >= 0) {
		                    dp[i] += dp[i - coins[j]];
		                }
		            }
		        }
		        return dp[amount];
	}
}
//iterate and convert -1 to 0 in the above solution. 
