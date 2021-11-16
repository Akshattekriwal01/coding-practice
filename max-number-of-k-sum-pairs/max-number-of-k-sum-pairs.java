// we have to find the number of pair with a given sum.
//[1-> 1, 3->3, 4->1]
//  [3,1,3,4,3]
//   i.      j

class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int count  = 0 ;
        for(int i = 0 ; i < nums.length ;i++)
        {
            map.put(nums[i], map.getOrDefault(nums[i], 0 ) + 1) ;
            
            int complement = k - nums[i] ;
            
            if(map.containsKey(complement)){
                if(complement == nums[i] && map.get(complement) > 1 ){
                    map.put(complement, map.get(complement)-1); 
                    map.put(nums[i], map.get(nums[i])-1); 
                    count++;
                }else if (complement != nums[i] && map.get(complement) > 0){
                    map.put(complement, map.get(complement)-1); 
                     map.put(nums[i], map.get(nums[i])-1); 
                    count++;
                }  
            }
        }
        return count ;
    }
}