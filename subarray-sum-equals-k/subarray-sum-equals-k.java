        // brute force : find all subarrays and for each subarray check if sum == k O(N^3)
        // prefix sum : meaning find all subarrays and for each subarray last - first , O(n^2)
        // prefix sum : if 2 indexes have same prefix sum then you can say that the sum between the array is 0 ,
        // similarly if difference of 2 indexes is k then the sum between subarray is k ;
        
        
        /*
                    [0,1,1,2,0,0,2,3]
                            
                  0[0,2,4,6,7] k = 1 
        
        */
                // we can use a hashmap to store the current prefix sum and its poitsion, later if prefixxum - k = oldprfix sum then we have an answer ;
        
        // how big can things be? ti choose  between int and long?
        
class Solution {
    public int subarraySum(int[] nums, int k) {

        for(int i = 1 ; i< nums.length ; i++){
            nums[i] += nums[i-1];
        }
        
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>(); 
         int count = 0 ;
         map.put(0,1); // to handle the subarrays that start from the begining ; 
        for(int i = 0 ; i< nums.length ; i++){
             if(map.containsKey(nums[i]-k)){
                count += map.get(nums[i] - k );
            }
           map.put(nums[i], map.getOrDefault(nums[i],0)+1);// add to map after the query beause when k = 0, the number will subtract with itself and query map(himself), will return 1, where as the subarray size should eb 0 here;
             
        }
     
        
        return count; 
        
    }
}

// also think why this problem cannot be solved with sliding window, because, there are non positive numbers, 
// for example once we exceed k, we done have garuntee that we can below k if keep removing i's